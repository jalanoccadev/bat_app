package com.jalanocca.bat_backend.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jalanocca.bat_backend.exception.GitCommandException;
import com.jalanocca.bat_backend.service.GitService;

@Service
public class GitServiceImpl implements GitService {

	/**
	 * Ejecuta un comando git en consola con los parámetros dados.
	 * @param commandParts Lista de strings que forman el comando git (por ejemplo: ["status", "-s"])
	 * @return true si el comando terminó correctamente, false si hubo error
	 */
	private boolean executeGitCommand(List<String> commandParts, String basePath) {
		ProcessBuilder builder = new ProcessBuilder();
		//commandParts.add(0, "git");
		List<String> commands = new ArrayList<>();
		commands.add("git");
		commands.addAll(commandParts);
		builder.command(commands);
		builder.directory(new File(basePath));
		builder.redirectErrorStream(true);
		try {
			Process process = builder.start();
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
				while (reader.readLine() != null) {
					// Solo consumir la salida
				}
			}
			int exitCode = process.waitFor();
			return exitCode == 0;
		} catch (IOException | InterruptedException e) {
			return false;
		}
	}

	/**
	 * Clona un repositorio git en la ruta base dada.
	 */
	@Override
	public void executeClone(String basePath, String repoUrl) {
		System.out.println("Clonando repo: " + repoUrl + " en " + basePath);
		if (!this.executeGitCommand(List.of("clone", repoUrl), basePath)) {
			throw new GitCommandException("Error al clonar el repositorio: " + repoUrl);
		}
	}

	/**
	 * Hace pull en el repositorio ubicado en la ruta base dada.
	 */
	@Override
	public void executePull(String basePath) {
		System.out.println("Haciendo pull en repo: " + basePath);
		if (!this.executeGitCommand(List.of("pull"), basePath)) {
			throw new GitCommandException("Error al hacer pull en el repositorio: " + basePath);
		}
	}

	/**
	 * Hace fetch en el repositorio ubicado en la ruta base dada.
	 */
	@Override
	public void executeFetch(String basePath) {
		System.out.println("Haciendo fetch en repo: " + basePath);
		if (!this.executeGitCommand(List.of("fetch"), basePath)) {
			throw new GitCommandException("Error al hacer fetch en el repositorio: " + basePath);
		}
	}

	/**
	 * Hace checkout a la rama dada en el repositorio ubicado en la ruta base dada.
	 */
	@Override
	public void executeCheckout(String basePath, String branch) {
		System.out.println("Haciendo checkout a la rama: " + branch + " en repo: " + basePath);
		if (!this.executeGitCommand(List.of("checkout", branch), basePath)) {
			throw new GitCommandException("Error al hacer checkout a la rama: " + branch);
		}
	}

	/**
	 * Crea y hace checkout a una nueva rama en el repositorio ubicado en la ruta base dada.
	 */
	@Override
	public void executeCheckoutNewBranch(String basePath, String branch) {
		System.out.println("Creando y haciendo checkout a la nueva rama: " + branch + " en repo: " + basePath);
		if (!this.executeGitCommand(List.of("checkout", "-b", branch), basePath)) {
			throw new GitCommandException("Error al crear y hacer checkout a la nueva rama: " + branch);
		}
	}

	/**
	 * Agrega todos los archivos al staging area en el repositorio ubicado en la ruta base dada.
	 */
	@Override
	public void executeAddAll(String basePath) {
		System.out.println("Agregando todos los archivos al staging area en repo: " + basePath);
		if (!this.executeGitCommand(List.of("add", "."), basePath)) {
			throw new GitCommandException("Error al agregar archivos al staging area en: " + basePath);
		}
	}

	/**
	 * Hace un commit con mensaje por defecto en el repositorio ubicado en la ruta base dada.
	 */
	@Override
	public void executeDefaultBatCommit(String basePath, String branch) {
		System.out.println("Haciendo commit en la rama: " + branch + " en repo: " + basePath);
		if (!this.executeGitCommand(List.of("commit", "-m", "chore: " + branch + " Add ocd config by BAT"), basePath)) {
			throw new GitCommandException("Error al hacer commit en la rama: " + branch);
		}
	}

	/**
	 * Hace push de la rama dada en el repositorio ubicado en la ruta base dada.
	 */
	@Override
	public void executePushWithNewBranch(String basePath, String branch) {
		System.out.println("Haciendo push de la nueva rama: " + branch + " en repo: " + basePath);
		if (!this.executeGitCommand(List.of("push", "--set-upstream", "origin", branch), basePath)) {
			throw new GitCommandException("Error al hacer push de la nueva rama: " + branch);
		}
	}

}

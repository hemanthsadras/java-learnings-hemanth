package org.TraverseCSVTask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * This is Responsbile for writing list of string to a physical file on disk
 * 
 * @author hemant kumar
 *
 */
public class WriteToFileAction extends RecursiveAction {

	private static final long serialVersionUID = -4205447118208671781L;
	private List<String> lines;
	private String destinationPath;

	public WriteToFileAction(List<String> lines, String destinationPath) {
		this.lines = lines;
		this.destinationPath = destinationPath;
	}

	@Override
	protected void compute() {

		if (lines.size() > 100) {
			// if greater than 100 fprk the subtasks
			List<RecursiveAction> subTasks = getAllSubTasks();
			for (RecursiveAction task : subTasks) {
				task.fork();
			}
		} else {
			try {
				// if the lines are small enough write it to a file
				Files.write(Paths.get(destinationPath, LocalDateTime.now().toString()), lines);
			} catch (IOException e) {
				System.out.println("Failed to write to file");
			}
		}

	}

	private List<RecursiveAction> getAllSubTasks() {
		List<RecursiveAction> tasks = new ArrayList<RecursiveAction>();
		tasks.add(new WriteToFileAction(lines.subList(0, lines.size() / 2), destinationPath));
		tasks.add(new WriteToFileAction(lines.subList(lines.size() / 2, lines.size() - 1), destinationPath));
		return tasks;
	}

}

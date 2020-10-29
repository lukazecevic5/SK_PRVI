package test;

import java.util.List;

import utils.Entitet;
import utils.ImportExportYAMLImpl;

public class Main {

	public static void main(String[] args) throws Exception {

		ImportExportYAMLImpl impl = new ImportExportYAMLImpl();
		List<Entitet> entiteti = impl
				.importFileToObject("/home/ice-frog/Workspaces/Java/Softverske Komponente/YAML_Handler/data/data.yml");

		for (Entitet e : entiteti) {
			System.out.println(e);
		}

		impl.exportObjectToFile(entiteti,
				"/home/ice-frog/Workspaces/Java/Softverske Komponente/YAML_Handler/data/data.yml");

	}

}

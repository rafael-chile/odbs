package imdb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Storage {
	private String msg_prueba;
	private static List<Plot> plots = new ArrayList<Plot>();
	private static List<String> tags = new ArrayList<String>();
	private static volatile Storage storage_instance = null;

	private Storage() {
	}

	private static void initdata(){
		System.out.println("Inicializando datos...");
		tags.add("Etiqueta 1");
		tags.add("Etiqueta 2");
		tags.add("Etiqueta 3");
		tags.add("Etiqueta 4");
		
	}
	
	public static Storage getInstance() {
		if (storage_instance == null) {
			synchronized (Storage.class) {
				storage_instance = new Storage();
				initdata();
			}
		}
		return storage_instance;
	}

	//---Get y set

	public String getMsg_prueba() {
		return msg_prueba;
	}

	public void setMsg_prueba(String msg_prueba) {
		this.msg_prueba = msg_prueba;
	}

	public static List<String> getTags() {
		return tags;
	}

	public static void setTags(List<String> tags) {
		Storage.tags = tags;
	}

	public static void addPlot(String nombre, String color, List<String> tags){
		Plot plot = new Plot(nombre, color, tags);
		plots.add(plot);
		System.out.println("Se agreg— el plot");
	}
	
	public static void addPlot(String nombre, String color){
		Plot plot = new Plot(nombre, color);
		plots.add(plot);
		System.out.println("Se agreg— el plot");
	}

	/**
	 * @return the plots
	 */
	public static List<Plot> getPlots() {
		return plots;
	}

	/**
	 * @param plots the plots to set
	 */
	public static void setPlots(List<Plot> plots) {
		Storage.plots = plots;
	}

	public static Plot getPlot(String name){
		for(Plot p : plots){
			if(p.getNombre().equals(name))
				return p;
		}
		return null;
	}
	
	
}

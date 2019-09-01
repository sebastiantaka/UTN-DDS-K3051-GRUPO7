package negocio;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class ProgramadorDeTareas {
	
	
	private static Timer timer;
	private static Set<TimerTask> tareasProgramadas;
	
	public static Set<TimerTask> getTareasProgramadas() {
		if (tareasProgramadas == null) {
			tareasProgramadas = new HashSet<TimerTask>();
		}
		return tareasProgramadas;
	}

	public static Timer getTimer() {
		if(timer == null) {
			timer = new Timer();
		}
		return timer;
	}
	
}

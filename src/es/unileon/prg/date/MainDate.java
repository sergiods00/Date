package es.unileon.prg.date;

public class MainDate {

	public static void main(String[] args) {

		Date today;

		try {
			today = new Date(25, 12, 2019);
            System.out.println(today.toString());
            Date date = new Date(13, 12, 2019);
            System.out.println(today.iFisSame(date));
            System.out.println("Mes: "+ today.nameOfMonth());
            System.out.println("Estacion: "+ today.season());
            System.out.println("Meses restantes: "+ today.monthLeft());
            System.out.println("Días restantes: "+ today.daysLeft());
            System.out.println(today.monthsSameDays());
            System.out.println("Los dias desde el primero: "+today.daysSinceFirst());
            System.out.println("Intentos: "+ today.intentos());
            System.out.println("Intentos: "+ today.intentosDo());
            System.out.println("Dia de la semana: "+ today.dayOfWeek());
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}

	}

}

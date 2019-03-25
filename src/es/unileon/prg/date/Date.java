package es.unileon.prg.date;

public class Date{

    private int day;
    private int month;
    private int year;
    private int dayMonth;
    
    public Date(int day, int month, int year) throws DateException{
        this.year = year;
        if (month < 1 || month > 12) {
            throw new DateException("Mes " + month + " no valido." +" Valores posibles entre 1 y 12.");
        } else {
            this.month = month;
        }
        if (dayCorrect(day,month) == false) {
            throw new DateException("Dia " + day + " no valido para el mes "+ this.nameOfMonth() +". Valores posibles entre 1 y 31.");
        }else {
            this.day = day;
        }
       
    }
    @Override
	public String toString(){
		return this.day + "/" + this.month + "/" + this.year;
	}
    
    private boolean dayCorrect(int day,int month){
        boolean dia=true;
 
            switch (month) {
                case 1:           
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (day<1 || day>31) {
                        dia=false;
                    }
                    break;
                case 2:
                    if (day<1 || day>28) {
                        dia=false;
                    }
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    if (day<1 || day>30) {
                        dia=false;
                    }
                    break;
        }
        return dia;
    }
    
    public int getYear(){
        return this.year;
    }
    
    public int getMonth(){
        return this.month;
    }
    
    public int getDay(){
        return this.day;
    }
    
    public void setYear(int year){
        this.year = year;
    }
    
    public void setMonth(int month){
        this.month = month;
    }
    
    public void setDay(int day){
        this.day = day;
    }
    
    public boolean iFisSameYear(Date date){
        boolean salida = false;
        if (this.getYear() == date.getYear()) {
            salida = true;
        }
        return salida;
    }
    
    public boolean iFisSameMonth(Date date){
        boolean salida = false;
        if (this.getMonth() == date.getMonth()) {
            salida = true;
        }
        return salida;
    }
    
    public boolean iFisSameDay(Date date){
        boolean salida = false;
        if (this.getDay() == date.getDay()) {
            salida = true;
        }
        return salida;
    }
    public boolean iFisSame(Date date){
        boolean salida = false;
        if (this.getMonth() == date.getMonth() && this.getDay() == date.getDay() && this.getYear() == date.getYear()) {
            salida = true;
        }
        return salida;
    }

	
   public boolean isSameYear(Date date){
        return this.getYear() == date.getYear();
    }
    
    public boolean isSameMonth(Date date){
        return this.getMonth() == date.getMonth();
    }
    
    public boolean isSameDay(Date date){
        return this.getDay() == date.getDay();
    }
    
    public boolean isSame(Date date){
        return isSameDay(date)&& isSameMonth(date) && isSameYear(date);
    }

    public String nameOfMonth(){
        StringBuilder mes =  new StringBuilder();
        switch(this.month){
            case 1: mes.append("Enero");
                break;
            case 2: mes.append("Febrero");
                break;
            case 3: mes.append("Marzo");
                break;
            case 4: mes.append("Abril");
                break;
            case 5: mes.append("Mayo");
                break;
            case 6: mes.append("Junio");
                break;
            case 7: mes.append("Julio");
                break;
            case 8: mes.append("Agosto");
                break;
            case 9: mes.append("Septiembre");
                break;
            case 10: mes.append("Octubre");
                break;
            case 11: mes.append("Noviembre");
                break;
            case 12: mes.append("Diciembre");
                break;
        }
        return mes.toString();
    }
    
    public String season(){
        StringBuilder estacion =  new StringBuilder();
        switch(this.month){
            case 1:
            case 2:
            case 3:
                estacion.append("Invierno");
                break;
            case 4:
            case 5:
            case 6:
                estacion.append("Primavera");
                break;
            case 7:
            case 8:
            case 9:
                estacion.append("Verano");
                break;
            case 10:
            case 11:
            case 12:
                estacion.append("Otoño");
                break;
        }
        return estacion.toString();
    }
    
    public String monthLeft(){
        StringBuilder meses = new StringBuilder();
        int x = this.month;
        if (this.month == 12) {
            meses.append("0");
        }
        for (int i = this.month ; i <= 12 ; i++) {
            this.month = this.month + 1;
             meses.append(nameOfMonth());
             meses.append(" ");
        }
        this.month = x;
        return meses.toString();
    }
    
    public String daysLeft(){
         StringBuilder salida = new StringBuilder();
            if(this.month==1||this.month==3||this.month==5||this.month==7||this.month==8||this.month==10||this.month==12){
                for (int i=this.day+1; i<=31 ; ++i ) {
                   
                    salida.append(i);
                    salida.append(" ");
                }
            }
            else if(this.month==2){
                for (int i=this.day+1; i<=28 ; ++i ) {
                   
                    salida.append(i);
                    salida.append(" ");
                }
            }
            else{
                for (int i=this.day+1; i<=30 ; ++i ) {
                   
                    salida.append(i);
                    salida.append(" ");
                }
            }
        return salida.toString();
    }
    
    public String monthsSameDays(){
        StringBuilder dias =  new StringBuilder();
        switch(this.month){
            case 2:
                dias.append("Solo Febrero.");
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dias.append("Los meses iguales son: Enero, Marzo, Mayo, Julio, Agosto, Octubre y Diciembre.");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dias.append("Los meses iguales son: Abril, Junio, Septiembre y Noviembre.");
                break;
        }
        return dias.toString();
    }
    
    public int daysSinceFirst(){
        int days=0;
        for (int i = 1;i<this.month ; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                    days = days + 31;
                    break;
                case 2:
                    days = days + 28;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    days = days + 30;
                    break;
            }
        }
        days = days + this.day;
        return days;
    }
    
    public int intentosDo(){
        int x=0;
        int num=0;
        do{
            num = (int)(Math.random()*364+1);
            x = x + 1 ;
        }while(num!=this.daysSinceFirst());
 
        return x;
    }
    
    public int intentos(){
        int x=0;
        int num=0;
        while (num!=this.daysSinceFirst()){
               
            num = (int)(Math.random()*364+1);
            x = x + 1 ;
        }
        return x;
    }
    
    public String dayOfWeek(){
 
        StringBuilder dia = new StringBuilder();
        int i, t, l, s;
        i = (14-this.month)/12;
        t = this.year - i;
        s = this.month + 12 * i -2;
        l = (this.day + t + t/4 - t/100 + t/400 + (31*s)/12) %7;
            switch (l) {
                case 0:
                    dia.append("Domingo");
                    break;
                case 1:
                    dia.append("Lunes");
                    break;
                case 2:
                    dia.append("Martes");
                    break;
                case 3:
                    dia.append("Miercoles");
                    break;
                case 4:
                    dia.append("Jueves");
                    break;
                case 5:
                    dia.append("Viernes");
                    break;
                case 6:
                    dia.append("Sabado");
                    break;
            }
        return dia.toString();
    }
}
    

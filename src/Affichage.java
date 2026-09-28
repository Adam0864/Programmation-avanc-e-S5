public class Affichage extends Thread {
    String texte;
    static MyMutex sync_obj = new MyMutex();
    static Semaphore sem = new SemaphoreBinaire(-1);

    public Affichage (String txt) {
        texte = txt;
    }

    public void run(){
        sem.syncWait();
        for(int i=0;i<texte.length();i++){
            System.out.print(texte.charAt(i)); //System.out est la ressource critique
            try {sleep(100);}catch (InterruptedException e){};
        }
        sem.syncSignal();
    }
}

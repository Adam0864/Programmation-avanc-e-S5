import javax.swing.*;
import java.awt.*;

class UnMobile extends JPanel implements Runnable {
    int saLargeur, saHauteur, sonDebDessin,sonTemps;
    final int sonPas = 10, sonCote = 40;
    static Semaphore sem = new SemaphoreLim4(-1);
    boolean sectionCritique = false;


    UnMobile(int parsonTemps, int telleLargeur, int telleHauteur) {
        super();
        sonTemps = parsonTemps;
        saLargeur = telleLargeur;
        saHauteur = telleHauteur;
        setSize(telleLargeur, telleHauteur);
    }

    public void run() {
        int T = saLargeur - sonPas;
        // Aller
        for (sonDebDessin = 0; sonDebDessin < T/3; sonDebDessin += sonPas) {
            repaint();

            try {
                Thread.sleep(sonTemps);
            } catch (InterruptedException telleExcp) {
                telleExcp.printStackTrace();
            }
        }
        sem.syncWait();
        sectionCritique = true;
        // Section critique
        for (sonDebDessin = T/3; sonDebDessin < 2*T/3; sonDebDessin += sonPas) {
            repaint();

            try {
                Thread.sleep(sonTemps);
            } catch (InterruptedException telleExcp) {
                telleExcp.printStackTrace();
            }
        }
        sectionCritique = false;
        sem.syncSignal();
        for (sonDebDessin = 2*T/3; sonDebDessin < T; sonDebDessin += sonPas) {
            repaint();

            try {
                Thread.sleep(sonTemps);
            } catch (InterruptedException telleExcp) {
                telleExcp.printStackTrace();
            }
        }
        // Retour
        for (sonDebDessin = saLargeur; sonDebDessin > 2*T/3; sonDebDessin -= sonPas) {
            repaint();

            try {
                Thread.sleep(sonTemps);
            } catch (InterruptedException telleExcp) {
                telleExcp.printStackTrace();
            }
        }
        sem.syncWait();
        sectionCritique = true;
        for (sonDebDessin = 2*T/3; sonDebDessin > T/3; sonDebDessin -= sonPas) {
            repaint();

            try {
                Thread.sleep(sonTemps);
            } catch (InterruptedException telleExcp) {
                telleExcp.printStackTrace();
            }
        }
        sectionCritique = false;
        sem.syncSignal();
        for (sonDebDessin = T/3; sonDebDessin > 0; sonDebDessin -= sonPas) {
            repaint();

            try {
                Thread.sleep(sonTemps);
            } catch (InterruptedException telleExcp) {
                telleExcp.printStackTrace();
            }
        }
    }

    public void paintComponent(Graphics telCG) {
        super.paintComponent(telCG);

        if (sectionCritique)
            telCG.setColor(Color.red);
        else telCG.setColor(Color.black);

        telCG.fillRect(sonDebDessin, saHauteur / 2, sonCote, sonCote);
    }

}

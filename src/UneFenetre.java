import javax.swing.*;
import java.awt.*;

public class UneFenetre extends JFrame {
    private final int LARG = 1200, HAUT = 250;
    private final int NBRCOL=1;

    public UneFenetre(int nbCarre) {
        super("Un mobile");
        final int larg=800,haut=500;
        Container leConteneur = getContentPane();
        leConteneur.setLayout(new GridLayout(nbCarre,NBRCOL));

        UnMobile[] mesMobiles = new UnMobile[nbCarre];
        for (int i = 0; i < nbCarre; i++) {
            double temps = Math.random()*100;
            int monTemps = (int)temps;
            mesMobiles[i] = new UnMobile(monTemps,larg,haut/nbCarre);
            leConteneur.add(mesMobiles[i]);
            Thread tache = new Thread(mesMobiles[i]);
            tache.start();
        }

        setSize(LARG, HAUT);
        setVisible(true);
    }
}
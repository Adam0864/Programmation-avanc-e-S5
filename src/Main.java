//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        UneFenetre f = new UneFenetre(50);

        Affichage a = new Affichage("AAA");
        Affichage b = new Affichage("BB");
        Affichage c = new Affichage("CCCC");
        Affichage d = new Affichage("DDDDDD");
        a.start();
        b.start();
        c.start();
        d.start();
        }
    }
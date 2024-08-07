package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.services.impl.BotAgresivo;
import ar.edu.utn.frc.tup.lciii.services.impl.BotConservador;
import ar.edu.utn.frc.tup.lciii.services.impl.BotEquilibrado;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrintStatusTest {

    @Test
    void statusGameplay() {
        User user = new User("Tino");
        user.setMoney(1500);
        user.setPositionOnBoard(15);
        user.getProperties().add(new Property(true, "Propiedad", 1, "Cordoba", 10, 10, 10000, 1000000, "Cordoba", "Player", true,0,0,0,0,0,0,0));
        user.getProperties().add(new Property(true, "Propiedad", 2, "Santa Fe", 10, 10, 10000, 1000000, "Santa Fe", "Player", true,0,0,0,0,0,0,0));
        user.getRailways().add(new Railway(true, "Ralwaiy", 1, "Rail 1", 10, "player"));
        user.getRailways().add(new Railway(true, "Ralwaiy", 2, "Rail 3", 10, "player"));
        user.getCompanies().add(new Company(true, "Company", 1, "Company1", 10, "player"));
        user.getCompanies().add(new Company(true, "Company", 2, "Company2", 10, "player"));
        user.setLose(true);

        BotConservador botConservador = new BotConservador("BotConservador777");
        botConservador.setMoney(1500);
        botConservador.setPositionOnBoard(7);
        botConservador.getProperties().add(new Property(true, "Propiedad", 1, "Cordoba", 10, 10, 10000, 1000000, "Cordoba", "Player", true,0,0,0,0,0,0,0));
        botConservador.getProperties().add(new Property(true, "Propiedad", 2, "Santa Fe", 10, 10, 10000, 1000000, "Santa Fe", "Player", true,0,0,0,0,0,0,0));
        botConservador.getRailways().add(new Railway(true, "Ralwaiy", 1, "Rail 1", 10, "player"));
        botConservador.getRailways().add(new Railway(true, "Ralwaiy", 2, "Rail 3", 10, "player"));
        botConservador.getCompanies().add(new Company(true, "Company", 1, "Company1", 10, "player"));
        botConservador.getCompanies().add(new Company(true, "Company", 2, "Company2", 10, "player"));

        BotAgresivo botAgresivo = new BotAgresivo("BotAgressive112");
        botAgresivo.setMoney(100);
        botAgresivo.setPositionOnBoard(6);
        botAgresivo.getProperties().add(new Property(true, "Propiedad", 1, "Cordoba", 10, 10, 10000, 1000000, "Cordoba", "Player", true,0,0,0,0,0,0,0));
        botAgresivo.getProperties().add(new Property(true, "Propiedad", 2, "Santa Fe", 10, 10, 10000, 1000000, "Santa Fe", "Player", true,0,0,0,0,0,0,0));
        botAgresivo.getRailways().add(new Railway(true, "Ralwaiy", 1, "Rail 1", 10, "player"));
        botAgresivo.getRailways().add(new Railway(true, "Ralwaiy", 2, "Rail 3", 10, "player"));
        botAgresivo.getCompanies().add(new Company(true, "Company", 1, "Company1", 10, "player"));
        botAgresivo.getCompanies().add(new Company(true, "Company", 2, "Company2", 10, "player"));

        BotEquilibrado botEquilibrado = new BotEquilibrado("BotEquilibrado8778");
        botEquilibrado.setMoney(17);
        botEquilibrado.setPositionOnBoard(5);
        botEquilibrado.getProperties().add(new Property(true, "Propiedad", 1, "Cordoba", 10, 10, 10000, 1000000, "Cordoba", "Player", true,0,0,0,0,0,0,0));
        botEquilibrado.getProperties().add(new Property(true, "Propiedad", 2, "Santa Fe", 10, 10, 10000, 1000000, "Santa Fe", "Player", true,0,0,0,0,0,0,0));
        botEquilibrado.getRailways().add(new Railway(true, "Ralwaiy", 1, "Rail 1", 10, "player"));
        botEquilibrado.getRailways().add(new Railway(true, "Ralwaiy", 2, "Rail 3", 10, "player"));
        botEquilibrado.getCompanies().add(new Company(true, "Company", 1, "Company1", 10, "player"));
        botEquilibrado.getCompanies().add(new Company(true, "Company", 2, "Company2", 10, "player"));
        botEquilibrado.setLose(true);

        List<Player> players = new ArrayList<>();
        players.add(user); players.add(botAgresivo); players.add(botConservador); players.add(botEquilibrado);

        PrintStatus printStatus = new PrintStatus(players);
        printStatus.statusGameplay();
    }
}
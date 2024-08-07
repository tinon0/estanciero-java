package ar.edu.utn.frc.tup.lciii.model;

import ar.edu.utn.frc.tup.lciii.services.impl.BotAgresivo;
import ar.edu.utn.frc.tup.lciii.services.impl.BotConservador;
import ar.edu.utn.frc.tup.lciii.services.impl.BotEquilibrado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.WeakHashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class HandlerPartidaTest {
    private HandlerPartida handlerPartida;
    private Scanner mockScaner;

    @BeforeEach
    public void setUp() {

        mockScaner = mock(Scanner.class);
        when(mockScaner.nextLong()).thenReturn(100000L);
        when(mockScaner.nextInt()).thenReturn(1);
        handlerPartida = new HandlerPartida(mockScaner);

    }

    @Test
    public void iniciarPartida() {




        assertEquals(100000, handlerPartida.getMoneyToWin());

        assertEquals(3, handlerPartida.getJugadores().size());
        assertTrue(handlerPartida.getJugadores().get(1) instanceof BotEquilibrado);
        assertTrue(handlerPartida.getJugadores().get(2) instanceof BotConservador);
    }

    @Test
    void testDificultadSpawnBotMedio() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        when(mockScaner.nextInt()).thenReturn(2);

        Method dificultadSpawnBot = HandlerPartida.class.getDeclaredMethod("dificultadSpawnBot");
        dificultadSpawnBot.setAccessible(true);

        dificultadSpawnBot.invoke(handlerPartida);


        assertTrue(handlerPartida.getJugadores().get(3) instanceof BotEquilibrado);
        assertTrue(handlerPartida.getJugadores().get(4) instanceof BotConservador);
        assertTrue(handlerPartida.getJugadores().get(5) instanceof BotAgresivo);
    }

    @Test
    void testDificultadSpawnBotDificil() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        when(mockScaner.nextInt()).thenReturn(3);

        Method dificultadSpawnBot = HandlerPartida.class.getDeclaredMethod("dificultadSpawnBot");
        dificultadSpawnBot.setAccessible(true);

        dificultadSpawnBot.invoke(handlerPartida);

        assertTrue(handlerPartida.getJugadores().get(3) instanceof BotEquilibrado);
        assertTrue(handlerPartida.getJugadores().get(4) instanceof BotConservador);
        assertTrue(handlerPartida.getJugadores().get(5) instanceof BotConservador);
        assertTrue(handlerPartida.getJugadores().get(6) instanceof BotAgresivo);
    }

    @Test
    void testNextPlayer() {



        Player nextPlayer = handlerPartida.nextPlayer();

        assertInstanceOf(Player.class,nextPlayer);
    }

    @Test
    void testMenuDecision() {


        when(mockScaner.nextInt()).thenReturn(2);
        handlerPartida.menuDecision();

        when(mockScaner.nextInt()).thenReturn(3);
        handlerPartida.menuDecision();


    }

    @Test
    void corroborarMuertos(){
        User user = new User("nombre");
        user.setMoney(1);
        this.handlerPartida.getJugadores().add(user);
        assertEquals(4, this.handlerPartida.getJugadores().size());
        this.handlerPartida.corroborarMuertos();
        assertEquals(3, this.handlerPartida.getJugadores().size());

    }
    @Test
    void vender(){
        this.handlerPartida.vender();
        when(mockScaner.nextInt()).thenReturn(2);
    }
    @Test
    void mejorarPropiedad(){
        PrintStream original = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream tps = new PrintStream(baos);
        System.setOut(tps);
        this.handlerPartida.mejorarPropiedad();
        System.setOut(original);
        tps.flush();
        assertEquals("[30;41;3mEsta no es una casilla de Propiedad\u001B[0m", baos.toString().trim());
    }
    @Test
    void isCloseToBanckruptcy(){
        handlerPartida.getUsuario().setMoney(1);
        handlerPartida.getUsuario().setBancarrota(2);
        this.handlerPartida.isCloseToBanckruptcy();
    }
    @Test
    void venderCompania(){
        handlerPartida.venderCompania();
    }
    @Test
    void venderFerrocariles(){
        handlerPartida.venderFerrocariles();
    }
    @Test
    void statusGamePlay(){
        handlerPartida.statusGamePlay();
    }
    @Test
    void nextPlayer(){
        Player test = handlerPartida.nextPlayer();
        assertInstanceOf(Player.class, test);
    }


    @Test
    public void testHuboWinSolo() {

        assertFalse(handlerPartida.win());
    }
    @Test
    public void testHuboWin() {


        handlerPartida.getUsuario().setMoney(200000);
        assertTrue(handlerPartida.win());

        List<Player> list = new ArrayList<>();
        User user = handlerPartida.getUsuario();
        list.add(user);
        handlerPartida.setJugadores(list);
        assertTrue(handlerPartida.win());



        handlerPartida.setRetired(true);
        assertTrue(handlerPartida.win());
    }

}

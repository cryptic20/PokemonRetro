package com.herokuapp.GameState;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.io.IOException;
import com.herokuapp.Panels.GamePanel;
import com.herokuapp.TileMaps.Tilemap;
import com.herokuapp.TileMaps.TilemapUtility;
import com.herokuapp.player.Player;;

public class DemoMapState extends GameState {
  // screen size 1920x1080



  // Image image = Toolkit.getDefaultToolkit().getImage("g_rt_0.gif");


  // Animation anim = new Animation("g_dn", 5, 10);


  // spawn player halfway into tile + spawn location
  Player player = new Player(16 + 640, 22 + 320);
  TilemapUtility tilemapUtility = new TilemapUtility();
  Tilemap tilemap;

  boolean up_pressed = false;
  boolean dn_pressed = false;
  boolean lt_pressed = false;
  boolean rt_pressed = false;
  boolean A_pressed = false;
  boolean D_pressed = false;
  boolean S_pressed = false;
  boolean W_pressed = false;
  boolean space_pressed = false;
  boolean enter_pressed = false;

  public DemoMapState(GameStateManager gsm) {
    init();
  }


  public void init() {


    try {
      tilemap = tilemapUtility.loadMap("src/main/resources/tilemaps/tilemaptest.txt");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    player.setLevel(tilemap);


  }


  public void keyReleased(KeyEvent e) {

  }



  @Override
  public void update() {
    // TODO Auto-generated method stub
    if (W_pressed)
      player.moveUp();
    if (A_pressed)
      player.moveLeft();
    if (S_pressed)
      player.moveDown();
    if (D_pressed)
      player.moveRight();
    if (enter_pressed && player.hasEncounteredPokemon())
      System.out.println("go to battle state nowww");
    // GSM switch to battle state pass in pokemon found as parameter
  }



  @Override
  public void draw(Graphics2D g) {
    // clear screen
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

    tilemap.draw(g);
    player.draw(g);
  }



  @Override
  public void keyPressed(int k) {
    if (k == KeyEvent.VK_UP)
      up_pressed = true;
    if (k == KeyEvent.VK_DOWN)
      dn_pressed = true;
    if (k == KeyEvent.VK_LEFT)
      lt_pressed = true;
    if (k == KeyEvent.VK_RIGHT)
      rt_pressed = true;
    if (k == KeyEvent.VK_A)
      A_pressed = true;
    if (k == KeyEvent.VK_D)
      D_pressed = true;
    if (k == KeyEvent.VK_S)
      S_pressed = true;
    if (k == KeyEvent.VK_W)
      W_pressed = true;
    if (k == KeyEvent.VK_SPACE)
      space_pressed = true;
    if (k == KeyEvent.VK_ENTER)
      enter_pressed = true;
  }



  @Override
  public void keyReleased(int k) {
    // TODO Auto-generated method stub
    if (k == KeyEvent.VK_UP)
      up_pressed = false;
    if (k == KeyEvent.VK_DOWN)
      dn_pressed = false;
    if (k == KeyEvent.VK_LEFT)
      lt_pressed = false;
    if (k == KeyEvent.VK_RIGHT)
      rt_pressed = false;
    if (k == KeyEvent.VK_A)
      A_pressed = false;
    if (k == KeyEvent.VK_D)
      D_pressed = false;
    if (k == KeyEvent.VK_S)
      S_pressed = false;
    if (k == KeyEvent.VK_W)
      W_pressed = false;
    if (k == KeyEvent.VK_SPACE)
      space_pressed = false;
    if (k == KeyEvent.VK_ENTER)
      enter_pressed = false;
  }



}
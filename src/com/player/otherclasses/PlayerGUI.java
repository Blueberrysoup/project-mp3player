/***
* PlayerGUI - GUI for MP3player
* @author: Carina Ekström
* @version: 1.0
**/
package com.player.otherclasses;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class PlayerGUI implements ActionListener{

	private JFrame frmMpplayer;
	private JLabel lblNowPlaying;
	private JLabel lblFileName;
	private JButton btnOpen;
	private JButton btnPlay;
	private JButton btnPause;
	private JButton btnStop;
	private File selectedFile; 
	private PlayerMethods playerMethods = new PlayerMethods();
	final JFileChooser fileChooser = new JFileChooser();

	/**
	 * Constructor for MP3player application
	 */
	public PlayerGUI() {
		createGUI();
		addComponentsToFrame();
		addActionListeners();
	}

	/**
	 * Get MP3player frame
	 * @return frmMpplayer Main frame for MP3player application
	 */
	public JFrame getFrmMpplayer(){
		return frmMpplayer;
	}
	
	/**
	 * Create GUI for MP3player application
	 */
	private void createGUI() {
		frmMpplayer = new JFrame();
		frmMpplayer.getContentPane().setBackground(new Color(0, 128, 0));
		frmMpplayer.setTitle("My MP3 player");
		frmMpplayer.setBounds(100, 100, 448, 159);
		frmMpplayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMpplayer.getContentPane().setLayout(null);
		
		lblNowPlaying = new JLabel("Now playing:");
		lblNowPlaying.setForeground(Color.WHITE);
		lblNowPlaying.setBounds(12, 24, 107, 15);
		
		lblFileName = new JLabel("");
		lblFileName.setForeground(Color.WHITE);
		lblFileName.setBounds(117, 24, 309, 15);
		
		btnOpen = new JButton("");
		btnOpen.setBackground(Color.WHITE);
		btnOpen.setIcon(new ImageIcon(PlayerGUI.class.getResource("/resources/openp.jpg")));
		btnOpen.setBounds(65, 75, 55, 25);
		
		btnPlay = new JButton("");
		btnPlay.setBackground(Color.WHITE);
		btnPlay.setIcon(new ImageIcon(PlayerGUI.class.getResource("/resources/playp.jpg")));
		btnPlay.setBounds(155, 75, 55, 25);
		
		btnPause = new JButton("");
		btnPause.setBackground(Color.WHITE);
		btnPause.setIcon(new ImageIcon(PlayerGUI.class.getResource("/resources/pausep.jpg")));
		btnPause.setBounds(245, 75, 55, 25);
		
		btnStop = new JButton("");
		btnStop.setBackground(Color.WHITE);
		btnStop.setIcon(new ImageIcon(PlayerGUI.class.getResource("/resources/stopp.jpg")));
		btnStop.setBounds(335, 75, 55, 25);
	}
	
	/**
	 * Add components to MP3player main frame
	 */
	private void addComponentsToFrame() {
		frmMpplayer.getContentPane().add(lblNowPlaying);
		frmMpplayer.getContentPane().add(lblFileName);
		frmMpplayer.getContentPane().add(btnOpen);
		frmMpplayer.getContentPane().add(btnPlay);
		frmMpplayer.getContentPane().add(btnPause);
		frmMpplayer.getContentPane().add(btnStop);
	}

	/**
	 * Add action listeners for MP3player components
	 */
	public void addActionListeners(){
		btnOpen.addActionListener(this);
		btnPlay.addActionListener(this);
		btnPause.addActionListener(this);
		btnStop.addActionListener(this);		
	}
	
	/**
	 * Action handlers for MP3player components
	 * @param e action event
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOpen) {
			try {
				int returnVal = fileChooser.showOpenDialog(frmMpplayer);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					selectedFile = fileChooser.getSelectedFile();
					if (selectedFile.isFile()){
						playerMethods.open(selectedFile);
						lblFileName.setText(selectedFile.getName());
					}
				}			
			} catch (Exception ex){
				ex.getMessage();
			}
		}
		if (e.getSource() == btnPlay) {
			playerMethods.play();
		}
		if (e.getSource() == btnPause) {
			playerMethods.pause();
		}
		if (e.getSource() == btnStop) {
			playerMethods.stop();
		}
		
	}
}


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
	private PlayerMethods playerMethods = new PlayerMethods();
	private File selectedFile; 
	final JFileChooser fileChooser = new JFileChooser();

	/**
	 * 
	 */
	public JFrame getFrmMpplayer(){
		return frmMpplayer;
	}
	
	/**
	 * Create the application.
	 */
	public PlayerGUI() {
		createGUI();
		addComponentsToFrame();
		addActionListeners();
	}

	/**
	 * Initialize the contents of the frame.
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
		lblFileName.setBounds(117, 24, 435, 15);
		
		btnOpen = new JButton("");
		btnOpen.setBackground(Color.WHITE);
		btnOpen.setIcon(new ImageIcon(PlayerGUI.class.getResource("/resources/openp.jpg")));
		btnOpen.setBounds(55, 75, 55, 25);
		
		btnPlay = new JButton("");
		btnPlay.setBackground(Color.WHITE);
		btnPlay.setIcon(new ImageIcon(PlayerGUI.class.getResource("/resources/playp.jpg")));
		btnPlay.setBounds(145, 75, 55, 25);
		
		btnPause = new JButton("");
		btnPause.setBackground(Color.WHITE);
		btnPause.setIcon(new ImageIcon(PlayerGUI.class.getResource("/resources/pausep.jpg")));
		btnPause.setBounds(235, 75, 55, 25);
		
		btnStop = new JButton("");
		btnStop.setBackground(Color.WHITE);
		btnStop.setIcon(new ImageIcon(PlayerGUI.class.getResource("/resources/stopp.jpg")));
		btnStop.setBounds(325, 75, 55, 25);
	}
	
	/**
	 * 
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
	 * 
	 */
	public void addActionListeners(){
		btnOpen.addActionListener(this);
		btnPlay.addActionListener(this);
		btnPause.addActionListener(this);
		btnStop.addActionListener(this);		
	}
	
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOpen) {
			int returnVal = fileChooser.showOpenDialog(frmMpplayer);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				selectedFile = fileChooser.getSelectedFile();				
				playerMethods.open(selectedFile);
				lblFileName.setText(selectedFile.getName());
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


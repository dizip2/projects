package pl.umk.mat.ksiegarnia.view.services;

import javax.swing.JOptionPane;

public class ServicesView extends javax.swing.JFrame
{
	/**
	 * shows message on screen
	 * @param string message
	 */
	public void showMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message);
	}
	/**
	 * shows frame
	 */
	public void showMe()
	{
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	/**
	 * close frame
	 */
	public void closeFrame()
	{
		dispose();
	}

}

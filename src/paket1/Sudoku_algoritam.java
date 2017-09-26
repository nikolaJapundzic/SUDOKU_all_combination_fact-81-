package paket1;

import java.awt.BorderLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Sudoku_algoritam {

	static int brojac = 0;
	public static JLabel label;
	
	public static void main(String[] args) {

		JFrame windows = new JFrame();
		windows.setTitle("Dobijanje svih kombinacija za sudoku");
		windows.setSize(250, 100);
		windows.setLayout(new BorderLayout());
		windows.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		windows.setResizable(false);
		
		JButton connectButton = new JButton("Pokreni");
		JPanel topPanel = new JPanel();
		label = new JLabel();
		label.setText("0");
		topPanel.add(connectButton);
		topPanel.add(label);
		windows.add(topPanel, BorderLayout.NORTH);
		//PRAVLJENJE EXIT BUTTON-A
		JButton exitButton = new JButton("EXIT");
		windows.add(exitButton, BorderLayout.SOUTH);
				
		windows.setVisible(true);
		
		
		exitButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent arg0) {
						
						System.exit(0);
					}
			});
		
				

		int [] niz = {1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,6,7,7,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,8,9,9,9,9,9,9,9,9,9};
		
		connectButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent arg0) {
				Thread tred = new Thread() {
					@Override public void run(){
						permute(niz, niz.length);
					}
				};
				tred.start();
			}
		});
		
		}

	    

	    private static void swap(int[] ourarray, int right, int left) {
	        int temp = ourarray[right];
	        ourarray[right] = ourarray[left];
	        ourarray[left] = temp;
	    }

	    public static void permute(int[] ourArray, int currentPosition) {
	        if (currentPosition == 1) {
	            String number = "";
	            boolean flag1 = true;
	            
	            for(int i =0; i<ourArray.length; i++) {
	            	number += ourArray[i];           	
	            }


	            
	            
	            
	          //provera prvog reda
	            if(ourArray[0]==ourArray[1] || ourArray[0]==ourArray[2] || ourArray[0]==ourArray[3] || ourArray[0]==ourArray[4] || ourArray[0]==ourArray[5] || ourArray[0]==ourArray[6] || ourArray[0]==ourArray[7] || ourArray[0]==ourArray[8] ||
	               ourArray[1]==ourArray[2] || ourArray[1]==ourArray[3] || ourArray[1]==ourArray[4] || ourArray[1]==ourArray[5] || ourArray[1]==ourArray[6] || ourArray[1]==ourArray[7] || ourArray[1]==ourArray[8] || 
	               ourArray[2]==ourArray[3] || ourArray[2]==ourArray[4] || ourArray[2]==ourArray[5] || ourArray[2]==ourArray[6] || ourArray[2]==ourArray[7] || ourArray[2]==ourArray[8] || 
	               ourArray[3]==ourArray[4] || ourArray[3]==ourArray[5] || ourArray[3]==ourArray[6] || ourArray[3]==ourArray[7] || ourArray[3]==ourArray[8] ||
	               ourArray[4]==ourArray[5] || ourArray[4]==ourArray[6] || ourArray[4]==ourArray[7] || ourArray[4]==ourArray[8] || 
	               ourArray[5]==ourArray[6] || ourArray[5]==ourArray[7] || ourArray[5]==ourArray[8] || 
	               ourArray[6]==ourArray[7] || ourArray[6]==ourArray[8] || 
	               ourArray[7]==ourArray[8]){
            		flag1 = false;
            	}
	          //provera drugog reda
	            if(flag1) {
	            	if( ourArray[9]==ourArray[10] || ourArray[9]==ourArray[11] || ourArray[9]==ourArray[12] || ourArray[9]==ourArray[13] || ourArray[9]==ourArray[14] || ourArray[9]==ourArray[15] || ourArray[9]==ourArray[16] || ourArray[9]==ourArray[17] ||
	            		ourArray[10]==ourArray[11] || ourArray[10]==ourArray[12] || ourArray[10]==ourArray[13] || ourArray[10]==ourArray[14] || ourArray[10]==ourArray[15] || ourArray[10]==ourArray[16] || ourArray[10]==ourArray[17] || 
	            		ourArray[11]==ourArray[12] || ourArray[11]==ourArray[13] || ourArray[11]==ourArray[14] || ourArray[11]==ourArray[15] || ourArray[11]==ourArray[16] || ourArray[11]==ourArray[17] ||
	            		ourArray[12]==ourArray[13] || ourArray[12]==ourArray[14] || ourArray[12]==ourArray[15] || ourArray[12]==ourArray[16] || ourArray[12]==ourArray[17] ||
	            		ourArray[13]==ourArray[14] || ourArray[13]==ourArray[15] || ourArray[13]==ourArray[16] || ourArray[13]==ourArray[17] || 
	            		ourArray[14]==ourArray[15] || ourArray[14]==ourArray[16] || ourArray[14]==ourArray[17] ||
	            		ourArray[15]==ourArray[16] || ourArray[15]==ourArray[17] || 
	     	            ourArray[16]==ourArray[17]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera treceg reda
	            if(flag1) {
	            	if( ourArray[18]==ourArray[19] || ourArray[18]==ourArray[20] || ourArray[18]==ourArray[21] || ourArray[18]==ourArray[22] || ourArray[18]==ourArray[23] || ourArray[18]==ourArray[24] || ourArray[18]==ourArray[25] || ourArray[18]==ourArray[26] ||
	            		ourArray[19]==ourArray[20] || ourArray[19]==ourArray[21] || ourArray[19]==ourArray[22] || ourArray[19]==ourArray[23] || ourArray[19]==ourArray[24] || ourArray[19]==ourArray[25] || ourArray[19]==ourArray[26] || 
	            		ourArray[20]==ourArray[21] || ourArray[20]==ourArray[22] || ourArray[20]==ourArray[23] || ourArray[20]==ourArray[24] || ourArray[20]==ourArray[25] || ourArray[20]==ourArray[26] ||
	            		ourArray[21]==ourArray[22] || ourArray[21]==ourArray[23] || ourArray[21]==ourArray[24] || ourArray[21]==ourArray[25] || ourArray[21]==ourArray[26] ||
	            		ourArray[22]==ourArray[22] || ourArray[22]==ourArray[24] || ourArray[22]==ourArray[25] || ourArray[22]==ourArray[26] ||
	            		ourArray[23]==ourArray[24] || ourArray[23]==ourArray[25] || ourArray[23]==ourArray[26] ||
	            		ourArray[24]==ourArray[25] || ourArray[24]==ourArray[26] || 
	     	            ourArray[25]==ourArray[26]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera cetvrtog reda
	            if(flag1) {
	            	if( ourArray[27]==ourArray[28] || ourArray[27]==ourArray[29] || ourArray[27]==ourArray[30] || ourArray[27]==ourArray[31] || ourArray[27]==ourArray[32] || ourArray[27]==ourArray[33] || ourArray[27]==ourArray[34] || ourArray[27]==ourArray[35] ||
	            		ourArray[28]==ourArray[29] || ourArray[28]==ourArray[30] || ourArray[28]==ourArray[31] || ourArray[28]==ourArray[32] || ourArray[28]==ourArray[33] || ourArray[28]==ourArray[34] || ourArray[28]==ourArray[35] ||
	            		ourArray[29]==ourArray[30] || ourArray[29]==ourArray[31] || ourArray[29]==ourArray[32] || ourArray[29]==ourArray[33] || ourArray[29]==ourArray[34] || ourArray[29]==ourArray[35] ||
	            		ourArray[30]==ourArray[31] || ourArray[30]==ourArray[32] || ourArray[30]==ourArray[33] || ourArray[30]==ourArray[34] || ourArray[30]==ourArray[35] ||
	            		ourArray[31]==ourArray[32] || ourArray[31]==ourArray[33] || ourArray[31]==ourArray[34] || ourArray[31]==ourArray[35] ||
	            		ourArray[32]==ourArray[33] || ourArray[32]==ourArray[34] || ourArray[32]==ourArray[35] ||
	            		ourArray[33]==ourArray[34] || ourArray[33]==ourArray[35] ||
	     	            ourArray[34]==ourArray[35]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera petog reda
	            if(flag1) {
	            	if( ourArray[36]==ourArray[37] || ourArray[36]==ourArray[38] || ourArray[36]==ourArray[39] || ourArray[36]==ourArray[40] || ourArray[36]==ourArray[41] || ourArray[36]==ourArray[42] || ourArray[36]==ourArray[43] || ourArray[36]==ourArray[44] ||
	            		ourArray[37]==ourArray[38] || ourArray[37]==ourArray[39] || ourArray[37]==ourArray[40] || ourArray[37]==ourArray[41] || ourArray[37]==ourArray[42] || ourArray[37]==ourArray[43] || ourArray[37]==ourArray[44] ||
	            		ourArray[38]==ourArray[39] || ourArray[38]==ourArray[40] || ourArray[38]==ourArray[41] || ourArray[38]==ourArray[42] || ourArray[38]==ourArray[43] || ourArray[38]==ourArray[44] ||
	            		ourArray[39]==ourArray[40] || ourArray[39]==ourArray[41] || ourArray[39]==ourArray[42] || ourArray[39]==ourArray[43] || ourArray[39]==ourArray[44] ||
	            		ourArray[40]==ourArray[41] || ourArray[40]==ourArray[42] || ourArray[40]==ourArray[43] || ourArray[40]==ourArray[44] ||
	            		ourArray[41]==ourArray[42] || ourArray[41]==ourArray[43] || ourArray[41]==ourArray[44] ||
	            		ourArray[42]==ourArray[43] || ourArray[42]==ourArray[44] ||
	     	            ourArray[43]==ourArray[44]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera sestog reda
	            if(flag1) {
	            	if( ourArray[45]==ourArray[46] || ourArray[45]==ourArray[47] || ourArray[45]==ourArray[48] || ourArray[45]==ourArray[49] || ourArray[45]==ourArray[50] || ourArray[45]==ourArray[51] || ourArray[45]==ourArray[52] || ourArray[45]==ourArray[53] ||
	            		ourArray[46]==ourArray[47] || ourArray[46]==ourArray[48] || ourArray[46]==ourArray[49] || ourArray[46]==ourArray[50] || ourArray[46]==ourArray[51] || ourArray[46]==ourArray[52] || ourArray[46]==ourArray[53] ||
	            		ourArray[47]==ourArray[48] || ourArray[47]==ourArray[49] || ourArray[47]==ourArray[50] || ourArray[47]==ourArray[51] || ourArray[47]==ourArray[52] || ourArray[47]==ourArray[53] ||
	            		ourArray[48]==ourArray[49] || ourArray[48]==ourArray[50] || ourArray[48]==ourArray[51] || ourArray[48]==ourArray[52] || ourArray[48]==ourArray[53] ||
	            		ourArray[49]==ourArray[50] || ourArray[49]==ourArray[51] || ourArray[49]==ourArray[52] || ourArray[49]==ourArray[53] ||
	            		ourArray[50]==ourArray[51] || ourArray[50]==ourArray[52] || ourArray[50]==ourArray[53] ||
	            		ourArray[51]==ourArray[52] || ourArray[51]==ourArray[53] ||
	     	            ourArray[52]==ourArray[53]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera sedmog reda
	            if(flag1) {
	            	if( ourArray[54]==ourArray[55] || ourArray[54]==ourArray[56] || ourArray[54]==ourArray[57] || ourArray[54]==ourArray[58] || ourArray[54]==ourArray[59] || ourArray[54]==ourArray[60] || ourArray[54]==ourArray[61] || ourArray[54]==ourArray[62] ||
	            		ourArray[55]==ourArray[56] || ourArray[55]==ourArray[57] || ourArray[55]==ourArray[58] || ourArray[55]==ourArray[59] || ourArray[55]==ourArray[60] || ourArray[55]==ourArray[61] || ourArray[55]==ourArray[62] ||
	            		ourArray[56]==ourArray[57] || ourArray[56]==ourArray[58] || ourArray[56]==ourArray[59] || ourArray[56]==ourArray[60] || ourArray[56]==ourArray[61] || ourArray[56]==ourArray[62] ||
	            		ourArray[57]==ourArray[58] || ourArray[57]==ourArray[59] || ourArray[57]==ourArray[60] || ourArray[57]==ourArray[61] || ourArray[57]==ourArray[62] ||
	            		ourArray[58]==ourArray[59] || ourArray[58]==ourArray[60] || ourArray[58]==ourArray[61] || ourArray[58]==ourArray[62] ||
	            		ourArray[59]==ourArray[60] || ourArray[59]==ourArray[61] || ourArray[59]==ourArray[62] ||
	            		ourArray[60]==ourArray[61] || ourArray[60]==ourArray[62] ||
	     	            ourArray[61]==ourArray[62]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera osmog reda
	            if(flag1) {
	            	if( ourArray[63]==ourArray[64] || ourArray[63]==ourArray[65] || ourArray[63]==ourArray[66] || ourArray[63]==ourArray[67] || ourArray[63]==ourArray[68] || ourArray[63]==ourArray[69] || ourArray[63]==ourArray[70] || ourArray[63]==ourArray[71] ||
	            		ourArray[64]==ourArray[65] || ourArray[64]==ourArray[66] || ourArray[64]==ourArray[67] || ourArray[64]==ourArray[68] || ourArray[64]==ourArray[69] || ourArray[64]==ourArray[70] || ourArray[64]==ourArray[71] ||
	            		ourArray[65]==ourArray[66] || ourArray[65]==ourArray[67] || ourArray[65]==ourArray[68] || ourArray[65]==ourArray[69] || ourArray[65]==ourArray[70] || ourArray[65]==ourArray[71] ||
	            		ourArray[66]==ourArray[67] || ourArray[66]==ourArray[68] || ourArray[66]==ourArray[69] || ourArray[66]==ourArray[70] || ourArray[66]==ourArray[71] ||
	            		ourArray[67]==ourArray[68] || ourArray[67]==ourArray[69] || ourArray[67]==ourArray[70] || ourArray[67]==ourArray[71] ||
	            		ourArray[68]==ourArray[69] || ourArray[68]==ourArray[70] || ourArray[68]==ourArray[71] ||
	            		ourArray[69]==ourArray[70] || ourArray[69]==ourArray[71] ||
	     	            ourArray[70]==ourArray[71]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera devetog reda
	            if(flag1) {
	            	if( ourArray[72]==ourArray[73] || ourArray[72]==ourArray[74] || ourArray[72]==ourArray[75] || ourArray[72]==ourArray[76] || ourArray[72]==ourArray[77] || ourArray[72]==ourArray[78] || ourArray[72]==ourArray[79] || ourArray[72]==ourArray[80] ||
	            		ourArray[73]==ourArray[74] || ourArray[73]==ourArray[75] || ourArray[73]==ourArray[76] || ourArray[73]==ourArray[77] || ourArray[73]==ourArray[78] || ourArray[73]==ourArray[79] || ourArray[73]==ourArray[80] ||
	            		ourArray[74]==ourArray[75] || ourArray[74]==ourArray[76] || ourArray[74]==ourArray[77] || ourArray[74]==ourArray[78] || ourArray[74]==ourArray[79] || ourArray[74]==ourArray[80] ||
	            		ourArray[75]==ourArray[76] || ourArray[75]==ourArray[77] || ourArray[75]==ourArray[78] || ourArray[75]==ourArray[79] || ourArray[75]==ourArray[80] ||
	            		ourArray[76]==ourArray[77] || ourArray[76]==ourArray[78] || ourArray[76]==ourArray[79] || ourArray[76]==ourArray[80] ||
	            		ourArray[77]==ourArray[78] || ourArray[77]==ourArray[79] || ourArray[77]==ourArray[80] ||
	            		ourArray[78]==ourArray[79] || ourArray[78]==ourArray[80] ||
	     	            ourArray[79]==ourArray[80]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera prve kolone
	            if(flag1) {
	            	if( ourArray[0]==ourArray[9] || ourArray[0]==ourArray[18] || ourArray[0]==ourArray[27] || ourArray[0]==ourArray[36] || ourArray[0]==ourArray[45] || ourArray[0]==ourArray[54] || ourArray[0]==ourArray[63] || ourArray[0]==ourArray[72] ||
	            		ourArray[9]==ourArray[18] || ourArray[9]==ourArray[27] || ourArray[9]==ourArray[36] || ourArray[9]==ourArray[45] || ourArray[9]==ourArray[54] || ourArray[9]==ourArray[63] || ourArray[9]==ourArray[72] ||
	            		ourArray[18]==ourArray[27] || ourArray[18]==ourArray[36] || ourArray[18]==ourArray[45] || ourArray[18]==ourArray[54] || ourArray[18]==ourArray[63] || ourArray[18]==ourArray[72] ||
	            		ourArray[27]==ourArray[36] || ourArray[27]==ourArray[45] || ourArray[27]==ourArray[54] || ourArray[27]==ourArray[63] || ourArray[27]==ourArray[72] ||
	            		ourArray[36]==ourArray[45] || ourArray[36]==ourArray[54] || ourArray[36]==ourArray[63] || ourArray[36]==ourArray[72] ||
	            		ourArray[45]==ourArray[54] || ourArray[45]==ourArray[63] || ourArray[45]==ourArray[72] ||
	            		ourArray[54]==ourArray[63] || ourArray[54]==ourArray[72] ||
	     	            ourArray[63]==ourArray[72]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera druge kolone
	            if(flag1) {
	            	if( ourArray[1]==ourArray[10] || ourArray[1]==ourArray[19] || ourArray[1]==ourArray[28] || ourArray[1]==ourArray[37] || ourArray[1]==ourArray[46] || ourArray[1]==ourArray[55] || ourArray[1]==ourArray[64] || ourArray[1]==ourArray[73] ||
	            		ourArray[10]==ourArray[19] || ourArray[10]==ourArray[28] || ourArray[10]==ourArray[37] || ourArray[10]==ourArray[46] || ourArray[10]==ourArray[55] || ourArray[10]==ourArray[64] || ourArray[10]==ourArray[73] ||
	            		ourArray[19]==ourArray[28] || ourArray[19]==ourArray[37] || ourArray[19]==ourArray[46] || ourArray[19]==ourArray[55] || ourArray[19]==ourArray[64] || ourArray[19]==ourArray[73] ||
	            		ourArray[28]==ourArray[37] || ourArray[28]==ourArray[46] || ourArray[28]==ourArray[55] || ourArray[28]==ourArray[64] || ourArray[28]==ourArray[73] ||
	            		ourArray[37]==ourArray[46] || ourArray[37]==ourArray[55] || ourArray[37]==ourArray[64] || ourArray[37]==ourArray[73] ||
	            		ourArray[46]==ourArray[55] || ourArray[46]==ourArray[64] || ourArray[46]==ourArray[73] ||
	            		ourArray[55]==ourArray[64] || ourArray[55]==ourArray[73] ||
	     	            ourArray[64]==ourArray[73]){
	                 		flag1 = false;
	                 	}
	            }
	            
	          //provera trece kolone
	            if(flag1) {
	            	if( ourArray[2]==ourArray[11] || ourArray[2]==ourArray[20] || ourArray[2]==ourArray[29] || ourArray[2]==ourArray[38] || ourArray[2]==ourArray[47] || ourArray[2]==ourArray[56] || ourArray[2]==ourArray[65] || ourArray[2]==ourArray[74] ||
	            		ourArray[11]==ourArray[20] || ourArray[11]==ourArray[29] || ourArray[11]==ourArray[38] || ourArray[11]==ourArray[47] || ourArray[11]==ourArray[56] || ourArray[11]==ourArray[65] || ourArray[11]==ourArray[74] ||
	            		ourArray[20]==ourArray[29] || ourArray[20]==ourArray[38] || ourArray[20]==ourArray[47] || ourArray[20]==ourArray[56] || ourArray[20]==ourArray[65] || ourArray[20]==ourArray[74] ||
	            		ourArray[29]==ourArray[38] || ourArray[29]==ourArray[47] || ourArray[29]==ourArray[56] || ourArray[29]==ourArray[65] || ourArray[29]==ourArray[74] ||
	            		ourArray[38]==ourArray[47] || ourArray[38]==ourArray[56] || ourArray[38]==ourArray[65] || ourArray[38]==ourArray[74] ||
	            		ourArray[47]==ourArray[56] || ourArray[47]==ourArray[65] || ourArray[47]==ourArray[74] ||
	            		ourArray[56]==ourArray[65] || ourArray[56]==ourArray[74] ||
	     	            ourArray[65]==ourArray[74]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera cetvrte kolone
	            if(flag1) {
	            	if( ourArray[3]==ourArray[12] || ourArray[3]==ourArray[21] || ourArray[3]==ourArray[30] || ourArray[3]==ourArray[39] || ourArray[3]==ourArray[48] || ourArray[3]==ourArray[57] || ourArray[3]==ourArray[66] || ourArray[3]==ourArray[75] ||
	            		ourArray[12]==ourArray[21] || ourArray[12]==ourArray[30] || ourArray[12]==ourArray[39] || ourArray[12]==ourArray[48] || ourArray[12]==ourArray[57] || ourArray[12]==ourArray[66] || ourArray[12]==ourArray[75] ||
	            		ourArray[21]==ourArray[30] || ourArray[21]==ourArray[39] || ourArray[21]==ourArray[48] || ourArray[21]==ourArray[57] || ourArray[21]==ourArray[66] || ourArray[21]==ourArray[75] ||
	            		ourArray[30]==ourArray[39] || ourArray[30]==ourArray[48] || ourArray[30]==ourArray[57] || ourArray[30]==ourArray[66] || ourArray[30]==ourArray[75] ||
	            		ourArray[39]==ourArray[48] || ourArray[39]==ourArray[57] || ourArray[39]==ourArray[66] || ourArray[39]==ourArray[75] ||
	            		ourArray[48]==ourArray[57] || ourArray[48]==ourArray[66] || ourArray[48]==ourArray[75] ||
	            		ourArray[57]==ourArray[66] || ourArray[57]==ourArray[75] ||
	     	            ourArray[66]==ourArray[75]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera pete kolone
	            if(flag1) {
	            	if( ourArray[4]==ourArray[13] || ourArray[4]==ourArray[22] || ourArray[4]==ourArray[31] || ourArray[4]==ourArray[40] || ourArray[4]==ourArray[49] || ourArray[4]==ourArray[58] || ourArray[4]==ourArray[67] || ourArray[4]==ourArray[76] ||
	            		ourArray[13]==ourArray[22] || ourArray[13]==ourArray[31] || ourArray[13]==ourArray[40] || ourArray[13]==ourArray[49] || ourArray[13]==ourArray[58] || ourArray[13]==ourArray[67] || ourArray[13]==ourArray[76] ||
	            		ourArray[22]==ourArray[31] || ourArray[22]==ourArray[40] || ourArray[22]==ourArray[49] || ourArray[22]==ourArray[58] || ourArray[22]==ourArray[67] || ourArray[22]==ourArray[76] ||
	            		ourArray[31]==ourArray[40] || ourArray[31]==ourArray[49] || ourArray[31]==ourArray[58] || ourArray[31]==ourArray[67] || ourArray[31]==ourArray[76] ||
	            		ourArray[40]==ourArray[49] || ourArray[40]==ourArray[58] || ourArray[40]==ourArray[67] || ourArray[40]==ourArray[76] ||
	            		ourArray[49]==ourArray[58] || ourArray[49]==ourArray[67] || ourArray[49]==ourArray[76] ||
	            		ourArray[58]==ourArray[67] || ourArray[58]==ourArray[76] ||
	     	            ourArray[67]==ourArray[76]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera seste kolone
	            if(flag1) {
	            	if( ourArray[5]==ourArray[14] || ourArray[5]==ourArray[23] || ourArray[5]==ourArray[32] || ourArray[5]==ourArray[41] || ourArray[5]==ourArray[50] || ourArray[5]==ourArray[59] || ourArray[5]==ourArray[68] || ourArray[5]==ourArray[77] ||
	            		ourArray[14]==ourArray[23] || ourArray[14]==ourArray[32] || ourArray[14]==ourArray[41] || ourArray[14]==ourArray[50] || ourArray[14]==ourArray[59] || ourArray[14]==ourArray[68] || ourArray[14]==ourArray[77] ||
	            		ourArray[23]==ourArray[32] || ourArray[23]==ourArray[41] || ourArray[23]==ourArray[50] || ourArray[23]==ourArray[59] || ourArray[23]==ourArray[68] || ourArray[23]==ourArray[77] ||
	            		ourArray[32]==ourArray[41] || ourArray[32]==ourArray[50] || ourArray[32]==ourArray[59] || ourArray[32]==ourArray[68] || ourArray[32]==ourArray[77] ||
	            		ourArray[41]==ourArray[50] || ourArray[41]==ourArray[59] || ourArray[41]==ourArray[68] || ourArray[41]==ourArray[77] ||
	            		ourArray[50]==ourArray[59] || ourArray[50]==ourArray[68] || ourArray[50]==ourArray[77] ||
	            		ourArray[59]==ourArray[68] || ourArray[59]==ourArray[77] ||
	     	            ourArray[68]==ourArray[77]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera sedme kolone
	            if(flag1) {
	            	if( ourArray[6]==ourArray[15] || ourArray[6]==ourArray[24] || ourArray[6]==ourArray[33] || ourArray[6]==ourArray[42] || ourArray[6]==ourArray[51] || ourArray[6]==ourArray[60] || ourArray[6]==ourArray[69] || ourArray[6]==ourArray[78] ||
	            		ourArray[15]==ourArray[24] || ourArray[15]==ourArray[33] || ourArray[15]==ourArray[42] || ourArray[15]==ourArray[51] || ourArray[15]==ourArray[60] || ourArray[15]==ourArray[69] || ourArray[15]==ourArray[78] ||
	            		ourArray[24]==ourArray[33] || ourArray[24]==ourArray[42] || ourArray[24]==ourArray[51] || ourArray[24]==ourArray[60] || ourArray[24]==ourArray[69] || ourArray[24]==ourArray[78] ||
	            		ourArray[33]==ourArray[42] || ourArray[33]==ourArray[51] || ourArray[33]==ourArray[60] || ourArray[33]==ourArray[69] || ourArray[33]==ourArray[78] ||
	            		ourArray[42]==ourArray[51] || ourArray[42]==ourArray[60] || ourArray[42]==ourArray[69] || ourArray[42]==ourArray[78] ||
	            		ourArray[51]==ourArray[60] || ourArray[51]==ourArray[69] || ourArray[51]==ourArray[78] ||
	            		ourArray[60]==ourArray[69] || ourArray[60]==ourArray[78] ||
	     	            ourArray[69]==ourArray[78]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera osme kolone
	            if(flag1) {
	            	if( ourArray[7]==ourArray[16] || ourArray[7]==ourArray[25] || ourArray[7]==ourArray[34] || ourArray[7]==ourArray[43] || ourArray[7]==ourArray[52] || ourArray[7]==ourArray[61] || ourArray[7]==ourArray[70] || ourArray[7]==ourArray[79] ||
	            		ourArray[16]==ourArray[25] || ourArray[16]==ourArray[34] || ourArray[16]==ourArray[43] || ourArray[16]==ourArray[52] || ourArray[16]==ourArray[61] || ourArray[16]==ourArray[70] || ourArray[16]==ourArray[79] ||
	            		ourArray[25]==ourArray[34] || ourArray[25]==ourArray[43] || ourArray[25]==ourArray[52] || ourArray[25]==ourArray[61] || ourArray[25]==ourArray[70] || ourArray[25]==ourArray[79] ||
	            		ourArray[34]==ourArray[43] || ourArray[34]==ourArray[52] || ourArray[34]==ourArray[61] || ourArray[34]==ourArray[70] || ourArray[34]==ourArray[79] ||
	            		ourArray[43]==ourArray[52] || ourArray[43]==ourArray[61] || ourArray[43]==ourArray[70] || ourArray[43]==ourArray[79] ||
	            		ourArray[52]==ourArray[61] || ourArray[52]==ourArray[70] || ourArray[52]==ourArray[79] ||
	            		ourArray[61]==ourArray[70] || ourArray[61]==ourArray[79] ||
	     	            ourArray[70]==ourArray[79]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera devete kolone
	            if(flag1) {
	            	if( ourArray[8]==ourArray[17] || ourArray[8]==ourArray[26] || ourArray[8]==ourArray[35] || ourArray[8]==ourArray[44] || ourArray[8]==ourArray[53] || ourArray[8]==ourArray[62] || ourArray[8]==ourArray[71] || ourArray[8]==ourArray[80] ||
	            		ourArray[17]==ourArray[26] || ourArray[17]==ourArray[35] || ourArray[17]==ourArray[44] || ourArray[17]==ourArray[53] || ourArray[17]==ourArray[62] || ourArray[17]==ourArray[71] || ourArray[17]==ourArray[80] ||
	            		ourArray[26]==ourArray[35] || ourArray[26]==ourArray[44] || ourArray[26]==ourArray[53] || ourArray[26]==ourArray[62] || ourArray[26]==ourArray[71] || ourArray[26]==ourArray[80] ||
	            		ourArray[35]==ourArray[44] || ourArray[35]==ourArray[53] || ourArray[35]==ourArray[62] || ourArray[35]==ourArray[71] || ourArray[35]==ourArray[80] ||
	            		ourArray[44]==ourArray[53] || ourArray[44]==ourArray[62] || ourArray[44]==ourArray[71] || ourArray[44]==ourArray[80] ||
	            		ourArray[53]==ourArray[62] || ourArray[53]==ourArray[71] || ourArray[53]==ourArray[80] ||
	            		ourArray[62]==ourArray[71] || ourArray[62]==ourArray[80] ||
	     	            ourArray[71]==ourArray[80]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera prve matrice
	            if(flag1) {
	            	if( ourArray[0]==ourArray[1] || ourArray[0]==ourArray[2] || ourArray[0]==ourArray[9] || ourArray[0]==ourArray[10] || ourArray[0]==ourArray[11] || ourArray[0]==ourArray[18] || ourArray[0]==ourArray[19] || ourArray[0]==ourArray[20] ||
	            		ourArray[1]==ourArray[2] || ourArray[1]==ourArray[9] || ourArray[1]==ourArray[10] || ourArray[1]==ourArray[11] || ourArray[1]==ourArray[18] || ourArray[1]==ourArray[19] || ourArray[1]==ourArray[20] ||
	            		ourArray[2]==ourArray[9] || ourArray[2]==ourArray[10] || ourArray[2]==ourArray[11] || ourArray[2]==ourArray[18] || ourArray[2]==ourArray[19] || ourArray[2]==ourArray[20] ||
	            		ourArray[9]==ourArray[10] || ourArray[9]==ourArray[11] || ourArray[9]==ourArray[18] || ourArray[9]==ourArray[19] || ourArray[9]==ourArray[20] ||
	            		ourArray[10]==ourArray[11] || ourArray[10]==ourArray[18] || ourArray[10]==ourArray[19] || ourArray[10]==ourArray[20] ||
	            		ourArray[11]==ourArray[18] || ourArray[11]==ourArray[19] || ourArray[11]==ourArray[20] ||
	            		ourArray[18]==ourArray[19] || ourArray[18]==ourArray[20] ||
	     	            ourArray[19]==ourArray[20]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera druge matrice
	            if(flag1) {
	            	if( ourArray[3]==ourArray[4] || ourArray[3]==ourArray[5] || ourArray[3]==ourArray[12] || ourArray[3]==ourArray[13] || ourArray[3]==ourArray[14] || ourArray[3]==ourArray[21] || ourArray[3]==ourArray[22] || ourArray[3]==ourArray[23] ||
	            		ourArray[4]==ourArray[5] || ourArray[4]==ourArray[12] || ourArray[4]==ourArray[13] || ourArray[4]==ourArray[14] || ourArray[4]==ourArray[21] || ourArray[4]==ourArray[22] || ourArray[4]==ourArray[23] ||
	            		ourArray[5]==ourArray[12] || ourArray[5]==ourArray[13] || ourArray[5]==ourArray[14] || ourArray[5]==ourArray[21] || ourArray[5]==ourArray[22] || ourArray[5]==ourArray[23] ||
	            		ourArray[12]==ourArray[13] || ourArray[12]==ourArray[14] || ourArray[12]==ourArray[21] || ourArray[12]==ourArray[22] || ourArray[12]==ourArray[23] ||
	            		ourArray[13]==ourArray[14] || ourArray[13]==ourArray[21] || ourArray[13]==ourArray[22] || ourArray[13]==ourArray[23] ||
	            		ourArray[14]==ourArray[21] || ourArray[14]==ourArray[22] || ourArray[14]==ourArray[23] ||
	            		ourArray[21]==ourArray[22] || ourArray[21]==ourArray[23] ||
	     	            ourArray[22]==ourArray[23]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera trece matrice
	            if(flag1) {
	            	if( ourArray[6]==ourArray[7] || ourArray[6]==ourArray[8] || ourArray[6]==ourArray[15] || ourArray[6]==ourArray[16] || ourArray[6]==ourArray[17] || ourArray[6]==ourArray[24] || ourArray[6]==ourArray[25] || ourArray[6]==ourArray[26] ||
	            		ourArray[7]==ourArray[8] || ourArray[7]==ourArray[15] || ourArray[7]==ourArray[16] || ourArray[7]==ourArray[17] || ourArray[7]==ourArray[24] || ourArray[7]==ourArray[25] || ourArray[7]==ourArray[26] ||
	            		ourArray[8]==ourArray[15] || ourArray[8]==ourArray[16] || ourArray[8]==ourArray[17] || ourArray[8]==ourArray[24] || ourArray[8]==ourArray[25] || ourArray[8]==ourArray[26] ||
	            		ourArray[15]==ourArray[16] || ourArray[15]==ourArray[17] || ourArray[15]==ourArray[24] || ourArray[15]==ourArray[25] || ourArray[15]==ourArray[26] ||
	            		ourArray[16]==ourArray[17] || ourArray[16]==ourArray[24] || ourArray[16]==ourArray[25] || ourArray[16]==ourArray[26] ||
	            		ourArray[17]==ourArray[24] || ourArray[17]==ourArray[25] || ourArray[17]==ourArray[26] ||
	            		ourArray[24]==ourArray[25] || ourArray[24]==ourArray[26] ||
	     	            ourArray[25]==ourArray[26]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera cetvrte matrice
	            if(flag1) {
	            	if( ourArray[27]==ourArray[28] || ourArray[27]==ourArray[29] || ourArray[27]==ourArray[36] || ourArray[27]==ourArray[37] || ourArray[27]==ourArray[38] || ourArray[27]==ourArray[45] || ourArray[27]==ourArray[46] || ourArray[27]==ourArray[47] ||
	            		ourArray[28]==ourArray[29] || ourArray[28]==ourArray[36] || ourArray[28]==ourArray[37] || ourArray[28]==ourArray[38] || ourArray[28]==ourArray[45] || ourArray[28]==ourArray[46] || ourArray[28]==ourArray[47] ||
	            		ourArray[29]==ourArray[36] || ourArray[29]==ourArray[37] || ourArray[29]==ourArray[38] || ourArray[29]==ourArray[45] || ourArray[29]==ourArray[46] || ourArray[29]==ourArray[47] ||
	            		ourArray[36]==ourArray[37] || ourArray[36]==ourArray[38] || ourArray[36]==ourArray[45] || ourArray[36]==ourArray[46] || ourArray[36]==ourArray[47] ||
	            		ourArray[37]==ourArray[38] || ourArray[37]==ourArray[45] || ourArray[37]==ourArray[46] || ourArray[37]==ourArray[47] ||
	            		ourArray[38]==ourArray[45] || ourArray[38]==ourArray[46] || ourArray[38]==ourArray[47] ||
	            		ourArray[45]==ourArray[46] || ourArray[45]==ourArray[47] ||
	     	            ourArray[46]==ourArray[47]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera pete matrice
	            if(flag1) {
	            	if( ourArray[30]==ourArray[31] || ourArray[30]==ourArray[32] || ourArray[30]==ourArray[39] || ourArray[30]==ourArray[40] || ourArray[30]==ourArray[41] || ourArray[30]==ourArray[48] || ourArray[30]==ourArray[49] || ourArray[30]==ourArray[50] ||
	            		ourArray[31]==ourArray[32] || ourArray[31]==ourArray[39] || ourArray[31]==ourArray[40] || ourArray[31]==ourArray[41] || ourArray[31]==ourArray[48] || ourArray[31]==ourArray[49] || ourArray[31]==ourArray[50] ||
	            		ourArray[32]==ourArray[39] || ourArray[32]==ourArray[40] || ourArray[32]==ourArray[41] || ourArray[32]==ourArray[48] || ourArray[32]==ourArray[49] || ourArray[32]==ourArray[50] ||
	            		ourArray[39]==ourArray[40] || ourArray[39]==ourArray[41] || ourArray[39]==ourArray[48] || ourArray[39]==ourArray[49] || ourArray[39]==ourArray[50] ||
	            		ourArray[40]==ourArray[41] || ourArray[40]==ourArray[48] || ourArray[40]==ourArray[49] || ourArray[40]==ourArray[50] ||
	            		ourArray[41]==ourArray[48] || ourArray[41]==ourArray[49] || ourArray[41]==ourArray[50] ||
	            		ourArray[48]==ourArray[49] || ourArray[48]==ourArray[50] ||
	     	            ourArray[49]==ourArray[50]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera seste matrice
	            if(flag1) {
	            	if( ourArray[33]==ourArray[34] || ourArray[33]==ourArray[35] || ourArray[33]==ourArray[42] || ourArray[33]==ourArray[43] || ourArray[33]==ourArray[44] || ourArray[33]==ourArray[51] || ourArray[33]==ourArray[52] || ourArray[33]==ourArray[53] ||
	            		ourArray[34]==ourArray[35] || ourArray[34]==ourArray[42] || ourArray[34]==ourArray[43] || ourArray[34]==ourArray[44] || ourArray[34]==ourArray[51] || ourArray[34]==ourArray[52] || ourArray[34]==ourArray[53] ||
	            		ourArray[35]==ourArray[42] || ourArray[35]==ourArray[43] || ourArray[35]==ourArray[44] || ourArray[35]==ourArray[51] || ourArray[35]==ourArray[52] || ourArray[35]==ourArray[53] ||
	            		ourArray[42]==ourArray[43] || ourArray[42]==ourArray[44] || ourArray[42]==ourArray[51] || ourArray[42]==ourArray[52] || ourArray[42]==ourArray[53] ||
	            		ourArray[43]==ourArray[44] || ourArray[43]==ourArray[51] || ourArray[43]==ourArray[52] || ourArray[43]==ourArray[53] ||
	            		ourArray[44]==ourArray[51] || ourArray[44]==ourArray[52] || ourArray[44]==ourArray[53] ||
	            		ourArray[51]==ourArray[52] || ourArray[51]==ourArray[53] ||
	     	            ourArray[52]==ourArray[53]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera sedme matrice
	            if(flag1) {
	            	if( ourArray[54]==ourArray[55] || ourArray[54]==ourArray[56] || ourArray[54]==ourArray[63] || ourArray[54]==ourArray[64] || ourArray[54]==ourArray[65] || ourArray[54]==ourArray[72] || ourArray[54]==ourArray[73] || ourArray[54]==ourArray[74] ||
	            		ourArray[55]==ourArray[56] || ourArray[55]==ourArray[63] || ourArray[55]==ourArray[64] || ourArray[55]==ourArray[65] || ourArray[55]==ourArray[72] || ourArray[55]==ourArray[73] || ourArray[55]==ourArray[74] ||
	            		ourArray[56]==ourArray[63] || ourArray[56]==ourArray[64] || ourArray[56]==ourArray[65] || ourArray[56]==ourArray[72] || ourArray[56]==ourArray[73] || ourArray[56]==ourArray[74] ||
	            		ourArray[63]==ourArray[64] || ourArray[63]==ourArray[65] || ourArray[63]==ourArray[72] || ourArray[63]==ourArray[73] || ourArray[63]==ourArray[74] ||
	            		ourArray[64]==ourArray[65] || ourArray[64]==ourArray[72] || ourArray[64]==ourArray[73] || ourArray[64]==ourArray[74] ||
	            		ourArray[65]==ourArray[72] || ourArray[65]==ourArray[73] || ourArray[65]==ourArray[74] ||
	            		ourArray[72]==ourArray[73] || ourArray[72]==ourArray[74] ||
	     	            ourArray[73]==ourArray[74]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera osme matrice
	            if(flag1) {
	            	if( ourArray[57]==ourArray[58] || ourArray[57]==ourArray[59] || ourArray[57]==ourArray[66] || ourArray[57]==ourArray[67] || ourArray[57]==ourArray[68] || ourArray[57]==ourArray[75] || ourArray[57]==ourArray[76] || ourArray[57]==ourArray[77] ||
	            		ourArray[58]==ourArray[59] || ourArray[58]==ourArray[66] || ourArray[58]==ourArray[67] || ourArray[58]==ourArray[68] || ourArray[58]==ourArray[75] || ourArray[58]==ourArray[76] || ourArray[58]==ourArray[77] ||
	            		ourArray[59]==ourArray[66] || ourArray[59]==ourArray[67] || ourArray[59]==ourArray[68] || ourArray[59]==ourArray[75] || ourArray[59]==ourArray[76] || ourArray[59]==ourArray[77] ||
	            		ourArray[66]==ourArray[67] || ourArray[66]==ourArray[68] || ourArray[66]==ourArray[75] || ourArray[66]==ourArray[76] || ourArray[66]==ourArray[77] ||
	            		ourArray[67]==ourArray[68] || ourArray[67]==ourArray[75] || ourArray[67]==ourArray[76] || ourArray[67]==ourArray[77] ||
	            		ourArray[68]==ourArray[75] || ourArray[68]==ourArray[76] || ourArray[68]==ourArray[77] ||
	            		ourArray[75]==ourArray[76] || ourArray[75]==ourArray[77] ||
	     	            ourArray[76]==ourArray[77]){
	                 		flag1 = false;
	                 	}
	            }
	          //provera devete matrice
	            if(flag1) {
	            	if( ourArray[60]==ourArray[61] || ourArray[60]==ourArray[62] || ourArray[60]==ourArray[69] || ourArray[60]==ourArray[70] || ourArray[60]==ourArray[71] || ourArray[60]==ourArray[78] || ourArray[60]==ourArray[79] || ourArray[60]==ourArray[80] ||
	            		ourArray[61]==ourArray[62] || ourArray[61]==ourArray[69] || ourArray[61]==ourArray[70] || ourArray[61]==ourArray[71] || ourArray[61]==ourArray[78] || ourArray[61]==ourArray[79] || ourArray[61]==ourArray[80] ||
	            		ourArray[62]==ourArray[69] || ourArray[62]==ourArray[70] || ourArray[62]==ourArray[71] || ourArray[62]==ourArray[78] || ourArray[62]==ourArray[79] || ourArray[62]==ourArray[80] ||
	            		ourArray[69]==ourArray[70] || ourArray[69]==ourArray[71] || ourArray[69]==ourArray[78] || ourArray[69]==ourArray[79] || ourArray[69]==ourArray[80] ||
	            		ourArray[70]==ourArray[71] || ourArray[70]==ourArray[78] || ourArray[70]==ourArray[79] || ourArray[70]==ourArray[80] ||
	            		ourArray[71]==ourArray[78] || ourArray[71]==ourArray[79] || ourArray[71]==ourArray[80] ||
	            		ourArray[78]==ourArray[79] || ourArray[78]==ourArray[80] ||
	     	            ourArray[79]==ourArray[80]){
	                 		flag1 = false;
	                 	}
	            }
	            

	            
	            
	            if(flag1) {
	            	//System.out.println(number);
	            	brojac++;
	            	label.setText(String.valueOf(brojac));
	            	//System.out.println(brojac);
	            	//PRAVLJENJE BAZE PODATAKA
	        		Connection c = null;
	                try {
	                    //Inicjalizujemo drajver za SQLite
	                    Class.forName("org.sqlite.JDBC");
	                    //Upostavljamo konekciju sa bazom
	                    c = DriverManager.getConnection("jdbc:sqlite:Akvizicija_sa_vage.db");
	                    //SQL naredbe koje zelimo da posaljemo bazi
	                } catch ( Exception e )
	                /*Hvatamo bilo kakav izuzetak koji moze da znaci
	                   da ne mozemo da uspostavimo konekciju sa bazom
	                 */
	                {
	                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	                } finally{
	                    try {
	                        /*Zatvaramo konekciju sa bazom u slucaju da se desi neki
	                           izuzetak ili ako sve uspe uspesno da se izvrsi
	                         */
	                        c.close();
	                    } catch (SQLException e) {
	                        e.printStackTrace();
	                    }
	                }
	                //KREIRANJE TABELA
	                //Connection c = null;
	                Statement stmt = null;
	                try {
	                    Class.forName("org.sqlite.JDBC");
	                    c = DriverManager.getConnection("jdbc:sqlite:Sve kombinacije za sudoku.db");
	                    //System.out.println("Uspesno konektovano na bazu");

	                    /*
	                       Sve kolone imaju postavljeno NOT NULL mora se svakoj
	                       koloni navesti vrednost
	                       Kolona id je proglasena za primarni kljuc sa kljucnim recima
	                       PRRIMARY KEY
	                     */
	                    stmt = c.createStatement();
	                    String sql = "CREATE TABLE artikal " +
	                            "(id      INT PRIMARY KEY     NOT NULL," +
	                            " kombinacije    TEXT     NOT NULL)";
	                    stmt.executeUpdate(sql);
	                    stmt.close();


	                } catch ( Exception e ) {
	                    System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	                } finally{
	                    try {
	                        /*Zatvaramo konekciju sa bazom u slucaju da se desi neki
	                           izuzetak ili ako sve uspe uspesno da se izvrsi
	                         */
	                        c.close();
	                    } catch (SQLException e) {
	                        e.printStackTrace();
	                    }
	                }
	                //System.out.println("Tabele kreirane uspesno");
	              //POPUNJAVANJE TABELA
					   //Connection c = null;
				       //Statement stmt = null;
					   try {
				            Class.forName("org.sqlite.JDBC");
				            c = DriverManager.getConnection("jdbc:sqlite:Sve kombinacije za sudoku.db");

				            //System.out.println("Uspesno konektovano na bazu");

				            stmt = c.createStatement();
				            String sql = "INSERT INTO artikal (id,kombinacije) " +
				                    "VALUES ("+brojac+", "+number+" );";
				            stmt.executeUpdate(sql);
				            stmt.close();


				        } catch ( Exception e ) {
				            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
				        } finally{
				            try {
				                /*Zatvaramo konekciju sa bazom u slucaju da se desi neki
				                   izuzetak ili ako sve uspe uspesno da se izvrsi
				                 */
				                c.close();
				            } catch (SQLException e) {
				                e.printStackTrace();
				            }
				        }
				        //System.out.println("Uspesno ubacene vrednosti");
	            }
	            
	            


	            
	            // PROVERAVANJE SUDOKU KLAUZULA
	            
	        } else {
	            for (int i = 0; i < currentPosition; i++) {
	                permute(ourArray, currentPosition - 1);

	                if (currentPosition % 2 == 1) {
	                    swap(ourArray, 0, currentPosition - 1);
	                } else {
	                    swap(ourArray, i, currentPosition - 1);
	                }
	            }
	        }
	    }
		
		
		

}
	



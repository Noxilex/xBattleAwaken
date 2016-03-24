package mainPackage;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author cailliea
 * Class that generate a random Map.
 * Getter and setter of parameter like : the texture pack used for the map.
 * 
 */
public class Map {

	private String p = File.pathSeparator;
	private String rscPath = ".."+p+".."+p+"Resources"+p+"Textures"+p+"Maps"+p;
	private String basicTexturePath = rscPath+"Basic"+p;
	private String activeTexturePack;
	private Random rand = new Random();
	private int[][] intMap;
	private Case[][] caseMap;
	
	public Map() {
		this.activeTexturePack = basicTexturePath;
		this.intMap = generateNewMap(30, 20);
		logDisplayMap(intMap);
	}

	/**
	 * @return The integer array of the map
	 */
	public int[][] getMap() {
		return intMap;
	}
	
	/**
	 * @param Coord c
	 * @return the integer in the case [c.x][c.y]
	 */
	public int getIdCase(Coord c) {
		return intMap[c.x()][c.y()];
	}
	
	/**
	 * @return the path to the Maps textures packs folder
	 */
	public String getResourcePath() {
		return rscPath;
	}
	
	/**
	 * @return The Currently active texture pack
	 */
	public String getActiveTexturePack() {
		return activeTexturePack;
	}
	
	/**
	 * Set the new name of the active texture pack
	 * @param texturePackName
	 */
	public void setActiveTexturePack(String texturePackName) {
		this.activeTexturePack = texturePackName;
	}
	
	/**
	 * 
	 * @param lenX
	 * @param lenY
	 * @return the 
	 */
	private int[][] generateNewMap(int lenX, int lenY) {
		System.out.println("Generating a new map dim :"+lenX+"x"+lenY);
		int[][] map = new int[lenX][lenY];
		for (int x=0; x<lenX; x++) {
			for (int y=0; y<lenY; y++) {
				map[x][y] = rand.nextInt(8);
			}
		}
		return map;
	}

	
	
	/**
	 * Only for the debug. Display the map in character.
	 * @param map
	 */
	private void logDisplayMap(int[][] map){
		for (int x=0; x<map.length; x++) {
			System.out.print("|");
			for (int y=0; y<map[0].length; y++) {
				int t = map[x][y];
				String s;
				switch (t) {
					case 0 : s = "pl";
					break;
					case 1 : s = "sa";
					break;
					case 2 : s = "h1";
					break;
					case 3 : s = "h2";
					break;
					case 4 : s = "h3";
					break;
					case 5 : s = "w1";
					break;
					case 6 : s = "w2";
					break;
					case 7 : s = "w3";
					break;
					default: s = "##";
					break;
				}
				System.out.print(s+"|");
			}
			System.out.println();
		}
	}
	
}


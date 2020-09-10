package src;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.utils.ScreenPosition;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * An application with a basic interactive map. You can zoom and pan the map.
 */
public class MapInterface extends PApplet {
	int level = 0;
	UnfoldingMap map;
	SimplePointMarker AKMarker,ALMarker,ARMarker,AZMarker,CAMarker,COMarker,CTMarker,DEMarker,FLMarker,GAMarker,HIMarker,IAMarker,IDMarker,ILMarker,INMarker,KSMarker,KYMarker,LAMarker,MAMarker,MDMarker,MEMarker,MIMarker,MNMarker,MOMarker,MSMarker,MTMarker,NCMarker,NDMarker,NEMarker,NHMarker,NJMarker,NMMarker,NVMarker,NYMarker,OHMarker,OKMarker,ORMarker,PAMarker,RIMarker,SCMarker,SDMarker,TNMarker,TXMarker,UTMarker,VAMarker,VTMarker,WAMarker,WIMarker,WVMarker,WYMarker;
	Location AK,AL,AR,AZ,CA,CO,CT,DE,FL,GA,HI,IA,ID,IL,IN,KS,KY,LA,MA,MD,ME,MI,MN,MO,MS,MT,NC,ND,NE,NH,NJ,NM,NV,NY,OH,OK,OR,PA,RI,SC,SD,TN,TX,UT,VA,VT,WA,WI,WV,WY;
	PImage sort, menu;
	String[] yearlist= {"2018", "2019", "2020"}; 
	int cyear = 0;
	int csort = 0;
	static State [][] states= new State[51][4];
	MergeSort merger = new MergeSort();


	// sets up Papplet to show map of USA as well as menu image
	public void setup() {
        readfile();
		
		size(1600, 800, P2D);
		setVisible(true); 
		Location USA = new Location(37.0902,  -95.7129);
		setlocations();

		
		

	    menu = loadImage("menu.png");
		map = new UnfoldingMap(this, new Microsoft.RoadProvider());
		map.zoomAndPanTo(5, USA);
		map.setZoomRange(5, 5);
		map.setPanningRestriction( USA , 4000);
		MapUtils.createDefaultEventDispatcher(this, map);
		
	}
	
	public void mouseClicked() {
		// when the mouse is clicked on sorted screen will change what data is being sorted checking its mouse x and y postions relative to button on screen
		if(level == 1) {
		if(mouseX>= 850 && mouseX <= 1000 && mouseY>= 30 && mouseY <= 60) {
				if(cyear !=0) {
					cyear--;
					redraw();

				}
		}
		
		if(mouseX>= 1050 && mouseX <= 1170 && mouseY>= 30 && mouseY <= 60) {
				if(cyear !=2) {
					cyear++;
					redraw();

				}

		}
		
		//will exit the sort screen and return to heat map if mouse postion is in correct location of the button
		if(mouseX>= 1430 && mouseX <= 1480 && mouseY>= 760 && mouseY <= 780) {
			level = 0;
			redraw();

		}
		
	}
		
	// changes heat map display based on each year
	if(level == 0) {
		if(mouseX>= 1390 && mouseX <= 1505 && mouseY>= 534 && mouseY <= 558) {
			if(cyear !=0) {
				cyear--;
				sort();
				redraw();

			}
	}
	
	if(mouseX>= 1390 && mouseX <= 1505 && mouseY>= 586 && mouseY <= 609) {
			if(cyear !=2) {
				cyear++;
				sort();
				redraw();

			}

	}
	// changes to the sorted state menu
	if(mouseX>= 1387 && mouseX <= 1451 && mouseY>= 633 && mouseY <= 657) {
		level = 1;
		sort();
		redraw();

	}		
		
		
	}



	}
	public void draw() {
		
		// draws circles over lat and long changing size and colour based on hpi/pollution value
		if(level == 0) {
		map.draw();
		ScreenPosition AKPos = AKMarker.getScreenPosition(map);
		ScreenPosition ALPos = ALMarker.getScreenPosition(map);
		ScreenPosition ARPos = ARMarker.getScreenPosition(map);
		ScreenPosition AZPos = AZMarker.getScreenPosition(map);
		ScreenPosition CAPos = CAMarker.getScreenPosition(map);
		ScreenPosition COPos = COMarker.getScreenPosition(map);
		ScreenPosition CTPos = CTMarker.getScreenPosition(map);
		ScreenPosition DEPos = DEMarker.getScreenPosition(map);
		ScreenPosition FLPos = FLMarker.getScreenPosition(map);
		ScreenPosition GAPos = GAMarker.getScreenPosition(map);
		ScreenPosition HIPos = HIMarker.getScreenPosition(map);
		ScreenPosition IAPos = IAMarker.getScreenPosition(map);
		ScreenPosition IDPos = IDMarker.getScreenPosition(map);
		ScreenPosition ILPos = ILMarker.getScreenPosition(map);
		ScreenPosition INPos = INMarker.getScreenPosition(map);
		ScreenPosition KSPos = KSMarker.getScreenPosition(map);
		ScreenPosition KYPos = KYMarker.getScreenPosition(map);
		ScreenPosition LAPos = LAMarker.getScreenPosition(map);
		ScreenPosition MAPos = MAMarker.getScreenPosition(map);
		ScreenPosition MDPos = MDMarker.getScreenPosition(map);
		ScreenPosition MEPos = MEMarker.getScreenPosition(map);
		ScreenPosition MIPos = MIMarker.getScreenPosition(map);
		ScreenPosition MNPos = MNMarker.getScreenPosition(map);
		ScreenPosition MOPos = MOMarker.getScreenPosition(map);
		ScreenPosition MSPos = MSMarker.getScreenPosition(map);
		ScreenPosition MTPos = MTMarker.getScreenPosition(map);
		ScreenPosition NCPos = NCMarker.getScreenPosition(map);
		ScreenPosition NDPos = NDMarker.getScreenPosition(map);
		ScreenPosition NEPos = NEMarker.getScreenPosition(map);
		ScreenPosition NHPos = NHMarker.getScreenPosition(map);
		ScreenPosition NJPos = NJMarker.getScreenPosition(map);
		ScreenPosition NMPos = NMMarker.getScreenPosition(map);
		ScreenPosition NVPos = NVMarker.getScreenPosition(map);
		ScreenPosition NYPos = NYMarker.getScreenPosition(map);
		ScreenPosition OHPos = OHMarker.getScreenPosition(map);
		ScreenPosition OKPos = OKMarker.getScreenPosition(map);
		ScreenPosition ORPos = ORMarker.getScreenPosition(map);
		ScreenPosition PAPos = PAMarker.getScreenPosition(map);
		ScreenPosition RIPos = RIMarker.getScreenPosition(map);
		ScreenPosition SCPos = SCMarker.getScreenPosition(map);
		ScreenPosition SDPos = SDMarker.getScreenPosition(map);
		ScreenPosition TNPos = TNMarker.getScreenPosition(map);
		ScreenPosition TXPos = TXMarker.getScreenPosition(map);
		ScreenPosition UTPos = UTMarker.getScreenPosition(map);
		ScreenPosition VAPos = VAMarker.getScreenPosition(map);
		ScreenPosition VTPos = VTMarker.getScreenPosition(map);
		ScreenPosition WAPos = WAMarker.getScreenPosition(map);
		ScreenPosition WIPos = WIMarker.getScreenPosition(map);
		ScreenPosition WVPos = WVMarker.getScreenPosition(map);
		ScreenPosition WYPos = WYMarker.getScreenPosition(map);
		


		
		fill(normailze(states[0][cyear].hpi()/states[0][cyear].pollution()), 20, 0, 100);
		ellipse(AKPos.x, AKPos.y, normailze2(states[0][cyear].hpi()/states[0][cyear].pollution()),normailze2(states[0][cyear].hpi()/states[0][cyear].pollution()));
		
		fill(normailze(states[1][cyear].hpi()/states[1][cyear].pollution()), 20, 0, 100);
		ellipse(ALPos.x, ALPos.y, normailze2(states[1][cyear].hpi()/states[1][cyear].pollution()),normailze2(states[1][cyear].hpi()/states[1][cyear].pollution()));
		
		fill(normailze(states[2][cyear].hpi()/states[2][cyear].pollution()), 20, 0, 100);
		ellipse(ARPos.x, ARPos.y, normailze2(states[2][cyear].hpi()/states[2][cyear].pollution()),normailze2(states[2][cyear].hpi()/states[2][cyear].pollution()));
		
		fill(normailze(states[3][cyear].hpi()/states[3][cyear].pollution()), 20, 0, 100);
		ellipse(AZPos.x, AZPos.y, normailze2(states[3][cyear].hpi()/states[3][cyear].pollution()),normailze2(states[3][cyear].hpi()/states[3][cyear].pollution()));
		
		fill(normailze(states[4][cyear].hpi()/states[4][cyear].pollution()), 20, 0, 100);
		ellipse(CAPos.x, CAPos.y, normailze2(states[4][cyear].hpi()/states[4][cyear].pollution()),normailze2(states[4][cyear].hpi()/states[4][cyear].pollution()));
		
		fill(normailze(states[5][cyear].hpi()/states[5][cyear].pollution()), 20, 0, 100);
		ellipse(COPos.x, COPos.y,  normailze2(states[5][cyear].hpi()/states[5][cyear].pollution()),normailze2(states[5][cyear].hpi()/states[5][cyear].pollution()));
		
		fill(normailze(states[6][cyear].hpi()/states[6][cyear].pollution()), 20, 0, 100);
		ellipse(CTPos.x, CTPos.y,  normailze2(states[6][cyear].hpi()/states[6][cyear].pollution()),normailze2(states[6][cyear].hpi()/states[6][cyear].pollution()));
		
		fill(normailze(states[7][cyear].hpi()/states[7][cyear].pollution()), 20, 0, 100);
		ellipse(DEPos.x, DEPos.y, normailze2(states[7][cyear].hpi()/states[7][cyear].pollution()),normailze2(states[7][cyear].hpi()/states[7][cyear].pollution()));
		
		fill(normailze(states[8][cyear].hpi()/states[8][cyear].pollution()), 20, 0, 100);
		ellipse(FLPos.x, FLPos.y, normailze2(states[8][cyear].hpi()/states[8][cyear].pollution()),normailze2(states[8][cyear].hpi()/states[8][cyear].pollution()));
		
		fill(normailze(states[9][cyear].hpi()/states[9][cyear].pollution()), 20, 0, 100);
		ellipse(GAPos.x, GAPos.y, normailze2(states[9][cyear].hpi()/states[9][cyear].pollution()),normailze2(states[9][cyear].hpi()/states[9][cyear].pollution()));
		
		fill(normailze(states[10][cyear].hpi()/states[10][cyear].pollution()), 20, 0, 100);
		ellipse(HIPos.x, HIPos.y,  normailze2(states[10][cyear].hpi()/states[10][cyear].pollution()),normailze2(states[10][cyear].hpi()/states[10][cyear].pollution()));
		
		fill(normailze(states[11][cyear].hpi()/states[11][cyear].pollution()), 20, 0, 100);
		ellipse(IAPos.x, IAPos.y, normailze2(states[11][cyear].hpi()/states[11][cyear].pollution()),normailze2(states[11][cyear].hpi()/states[11][cyear].pollution()));
		
		fill(normailze(states[12][cyear].hpi()/states[12][cyear].pollution()), 20, 0, 100);
		ellipse(IDPos.x, IDPos.y,  normailze2(states[12][cyear].hpi()/states[12][cyear].pollution()),normailze2(states[12][cyear].hpi()/states[12][cyear].pollution()));
		
		fill(normailze(states[13][cyear].hpi()/states[13][cyear].pollution()), 20, 0, 100);
		ellipse(ILPos.x, ILPos.y, normailze2(states[13][cyear].hpi()/states[13][cyear].pollution()),normailze2(states[13][cyear].hpi()/states[13][cyear].pollution()));
		
		fill(normailze(states[14][cyear].hpi()/states[14][cyear].pollution()), 20, 0, 100);
		ellipse(INPos.x, INPos.y,  normailze2(states[14][cyear].hpi()/states[14][cyear].pollution()),normailze2(states[14][cyear].hpi()/states[14][cyear].pollution()));
		
		fill(normailze(states[15][cyear].hpi()/states[15][cyear].pollution()), 20, 0, 100);
		ellipse(KSPos.x, KSPos.y, normailze2(states[15][cyear].hpi()/states[15][cyear].pollution()),normailze2(states[15][cyear].hpi()/states[15][cyear].pollution()));
		
		fill(normailze(states[16][cyear].hpi()/states[16][cyear].pollution()), 20, 0, 100);
		ellipse(KYPos.x, KYPos.y, normailze2(states[16][cyear].hpi()/states[16][cyear].pollution()),normailze2(states[16][cyear].hpi()/states[16][cyear].pollution()));
		
		fill(normailze(states[17][cyear].hpi()/states[17][cyear].pollution()), 20, 0, 100);
		ellipse(LAPos.x, LAPos.y,  normailze2(states[17][cyear].hpi()/states[17][cyear].pollution()),normailze2(states[17][cyear].hpi()/states[17][cyear].pollution()));
		
		fill(normailze(states[18][cyear].hpi()/states[18][cyear].pollution()), 20, 0, 100);
		ellipse(MAPos.x, MAPos.y,  normailze2(states[18][cyear].hpi()/states[18][cyear].pollution()),normailze2(states[18][cyear].hpi()/states[18][cyear].pollution()));
		
		fill(normailze(states[19][cyear].hpi()/states[19][cyear].pollution()), 20, 0, 100);
		ellipse(MDPos.x, MDPos.y,  normailze2(states[19][cyear].hpi()/states[19][cyear].pollution()),normailze2(states[19][cyear].hpi()/states[19][cyear].pollution()));
		
		fill(normailze(states[20][cyear].hpi()/states[20][cyear].pollution()), 20, 0, 100);
		ellipse(MEPos.x, MEPos.y, normailze2(states[20][cyear].hpi()/states[20][cyear].pollution()),normailze2(states[20][cyear].hpi()/states[20][cyear].pollution()));
		
		fill(normailze(states[21][cyear].hpi()/states[21][cyear].pollution()), 20, 0, 100);
		ellipse(MIPos.x, MIPos.y, normailze2(states[21][cyear].hpi()/states[21][cyear].pollution()),normailze2(states[21][cyear].hpi()/states[21][cyear].pollution()));
		
		fill(normailze(states[22][cyear].hpi()/states[22][cyear].pollution()), 20, 0, 100);
		ellipse(MNPos.x, MNPos.y,  normailze2(states[22][cyear].hpi()/states[22][cyear].pollution()),normailze2(states[22][cyear].hpi()/states[22][cyear].pollution()));
		
		fill(normailze(states[23][cyear].hpi()/states[23][cyear].pollution()), 20, 0, 100);
		ellipse(MOPos.x, MOPos.y,  normailze2(states[23][cyear].hpi()/states[23][cyear].pollution()),normailze2(states[23][cyear].hpi()/states[23][cyear].pollution()));
		
		fill(normailze(states[24][cyear].hpi()/states[24][cyear].pollution()), 20, 0, 100);
		ellipse(MSPos.x, MSPos.y,  normailze2(states[24][cyear].hpi()/states[24][cyear].pollution()),normailze2(states[24][cyear].hpi()/states[24][cyear].pollution()));
		
		fill(normailze(states[25][cyear].hpi()/states[25][cyear].pollution()), 20, 0, 100);
		ellipse(MTPos.x, MTPos.y, normailze2(states[25][cyear].hpi()/states[25][cyear].pollution()),normailze2(states[25][cyear].hpi()/states[25][cyear].pollution()));
		
		fill(normailze(states[26][cyear].hpi()/states[26][cyear].pollution()), 20, 0, 100);
		ellipse(NCPos.x, NCPos.y, normailze2(states[26][cyear].hpi()/states[26][cyear].pollution()),normailze2(states[26][cyear].hpi()/states[26][cyear].pollution()));
		
		fill(normailze(states[27][cyear].hpi()/states[27][cyear].pollution()), 20, 0, 100);
		ellipse(NDPos.x, NDPos.y,  normailze2(states[27][cyear].hpi()/states[27][cyear].pollution()),normailze2(states[27][cyear].hpi()/states[27][cyear].pollution()));
		
		fill(normailze(states[28][cyear].hpi()/states[28][cyear].pollution()), 20, 0, 100);
		ellipse(NEPos.x, NEPos.y, normailze2(states[28][cyear].hpi()/states[28][cyear].pollution()),normailze2(states[28][cyear].hpi()/states[28][cyear].pollution()));
		
		fill(normailze(states[29][cyear].hpi()/states[29][cyear].pollution()), 20, 0, 100);
		ellipse(NHPos.x, NHPos.y, normailze2(states[29][cyear].hpi()/states[29][cyear].pollution()),normailze2(states[29][cyear].hpi()/states[29][cyear].pollution()));
		
		fill(normailze(states[30][cyear].hpi()/states[30][cyear].pollution()), 20, 0, 100);
		ellipse(NJPos.x, NJPos.y, normailze2(states[30][cyear].hpi()/states[30][cyear].pollution()),normailze2(states[30][cyear].hpi()/states[30][cyear].pollution()));
		
		fill(normailze(states[31][cyear].hpi()/states[31][cyear].pollution()), 20, 0, 100);
		ellipse(NMPos.x, NMPos.y,  normailze2(states[31][cyear].hpi()/states[31][cyear].pollution()),normailze2(states[31][cyear].hpi()/states[31][cyear].pollution()));
		
		fill(normailze(states[32][cyear].hpi()/states[32][cyear].pollution()), 20, 0, 100);
		ellipse(NVPos.x, NVPos.y,  normailze2(states[32][cyear].hpi()/states[32][cyear].pollution()),normailze2(states[32][cyear].hpi()/states[32][cyear].pollution()));
		
		fill(normailze(states[33][cyear].hpi()/states[33][cyear].pollution()), 20, 0, 100);
		ellipse(NYPos.x, NYPos.y,  normailze2(states[33][cyear].hpi()/states[33][cyear].pollution()),normailze2(states[33][cyear].hpi()/states[33][cyear].pollution()));
		
		fill(normailze(states[34][cyear].hpi()/states[34][cyear].pollution()), 20, 0, 100);
		ellipse(OHPos.x, OHPos.y,  normailze2(states[34][cyear].hpi()/states[49][cyear].pollution()),normailze2(states[34][cyear].hpi()/states[34][cyear].pollution()));
		
		fill(normailze(states[35][cyear].hpi()/states[35][cyear].pollution()), 20, 0, 100);
		ellipse(OKPos.x, OKPos.y,  normailze2(states[35][cyear].hpi()/states[35][cyear].pollution()),normailze2(states[35][cyear].hpi()/states[35][cyear].pollution()));
		
		fill(normailze(states[36][cyear].hpi()/states[36][cyear].pollution()), 20, 0, 100);
		ellipse(ORPos.x, ORPos.y,  normailze2(states[36][cyear].hpi()/states[36][cyear].pollution()),normailze2(states[36][cyear].hpi()/states[36][cyear].pollution()));
		
		fill(normailze(states[37][cyear].hpi()/states[37][cyear].pollution()), 20, 0, 100);
		ellipse(PAPos.x, PAPos.y, normailze2(states[37][cyear].hpi()/states[37][cyear].pollution()),normailze2(states[37][cyear].hpi()/states[37][cyear].pollution()));
		
		fill(normailze(states[38][cyear].hpi()/states[38][cyear].pollution()), 20, 0, 100);
		ellipse(RIPos.x, RIPos.y, normailze2(states[38][cyear].hpi()/states[38][cyear].pollution()),normailze2(states[38][cyear].hpi()/states[38][cyear].pollution()));
		
		fill(normailze(states[39][cyear].hpi()/states[39][cyear].pollution()), 20, 0, 100);
		ellipse(SCPos.x, SCPos.y,  normailze2(states[39][cyear].hpi()/states[39][cyear].pollution()),normailze2(states[39][cyear].hpi()/states[39][cyear].pollution()));
		
		fill(normailze(states[40][cyear].hpi()/states[40][cyear].pollution()), 20, 0, 100);
		ellipse(SDPos.x, SDPos.y,  normailze2(states[40][cyear].hpi()/states[40][cyear].pollution()),normailze2(states[40][cyear].hpi()/states[40][cyear].pollution()));
		
		fill(normailze(states[41][cyear].hpi()/states[41][cyear].pollution()), 20, 0, 100);
		ellipse(TNPos.x, TNPos.y,  normailze2(states[41][cyear].hpi()/states[41][cyear].pollution()),normailze2(states[41][cyear].hpi()/states[41][cyear].pollution()));
		
		fill(normailze(states[42][cyear].hpi()/states[42][cyear].pollution()), 20, 0, 100);
		ellipse(TXPos.x, TXPos.y,  normailze2(states[42][cyear].hpi()/states[42][cyear].pollution()),normailze2(states[42][cyear].hpi()/states[42][cyear].pollution()));
		
		fill(normailze(states[43][cyear].hpi()/states[43][cyear].pollution()), 20, 0, 100);
		ellipse(UTPos.x, UTPos.y, normailze2(states[43][cyear].hpi()/states[43][cyear].pollution()),normailze2(states[43][cyear].hpi()/states[43][cyear].pollution()));
		
		fill(normailze(states[44][cyear].hpi()/states[44][cyear].pollution()), 20, 0, 100);
		ellipse(VAPos.x, VAPos.y,  normailze2(states[44][cyear].hpi()/states[44][cyear].pollution()),normailze2(states[44][cyear].hpi()/states[44][cyear].pollution()));
	
		fill(normailze(states[45][cyear].hpi()/states[45][cyear].pollution()), 20, 0, 100);
		ellipse(VTPos.x, VTPos.y,  normailze2(states[45][cyear].hpi()/states[45][cyear].pollution()),normailze2(states[45][cyear].hpi()/states[45][cyear].pollution()));
		
		fill(normailze(states[46][cyear].hpi()/states[46][cyear].pollution()), 20, 0, 100);
		ellipse(WAPos.x, WAPos.y, normailze2(states[46][cyear].hpi()/states[46][cyear].pollution()),normailze2(states[46][cyear].hpi()/states[46][cyear].pollution()));
		
		fill(normailze(states[47][cyear].hpi()/states[47][cyear].pollution()), 20, 0, 100);
		ellipse(WIPos.x, WIPos.y,  normailze2(states[47][cyear].hpi()/states[47][cyear].pollution()),normailze2(states[47][cyear].hpi()/states[47][cyear].pollution()));
		
		fill(normailze(states[48][cyear].hpi()/states[48][cyear].pollution()), 20, 0, 100);
		ellipse(WVPos.x, WVPos.y,  normailze2(states[48][cyear].hpi()/states[48][cyear].pollution()),normailze2(states[48][cyear].hpi()/states[48][cyear].pollution()));
		
		fill(normailze(states[49][cyear].hpi()/states[49][cyear].pollution()), 20, 0, 100);
		ellipse(WYPos.x, WYPos.y, normailze2(states[49][cyear].hpi()/states[49][cyear].pollution()),normailze2(states[49][cyear].hpi()/states[49][cyear].pollution()));
		
		image(menu, 1350, 500);
		textSize(20);
		fill(0, 0, 0, 100);
		text(yearlist[cyear], 1483, 774);
		
		}
		
		if (level == 1) {
			// list states in decreasing order based on hpi/population value
			sort = loadImage("sortlist.png");
			image(sort, 0, 0);
			stroke(100, 0, 0, 100);
			textSize(12);
			fill(255,255,255,255);
			text("HPI / POLLUTION", 135, 95);
			text(yearlist[cyear], 80, 120);
			text(states[0][cyear].state() +" | "+ String.format("%.3f",(float)states[0][cyear].hpi()/states[0][cyear].pollution()), 90, 155);
			text(states[1][cyear].state() +" | "+ String.format("%.3f",(float)states[1][cyear].hpi()/states[1][cyear].pollution()), 300, 155);
			text(states[2][cyear].state() +" | "+ String.format("%.3f",(float)states[2][cyear].hpi()/states[2][cyear].pollution()), 510, 155);
			text(states[3][cyear].state() +" | "+ String.format("%.3f",(float)states[3][cyear].hpi()/states[3][cyear].pollution()), 720, 155);
			text(states[4][cyear].state() +" | "+ String.format("%.3f",(float)states[4][cyear].hpi()/states[4][cyear].pollution()), 930, 155);
			text(states[5][cyear].state() +" | "+ String.format("%.3f",(float)states[5][cyear].hpi()/states[5][cyear].pollution()), 1140, 155);
			text(states[6][cyear].state() +" | "+ String.format("%.3f",(float)states[6][cyear].hpi()/states[6][cyear].pollution()), 1360, 155);
			text(states[7][cyear].state() +" | "+ String.format("%.3f",(float)states[7][cyear].hpi()/states[7][cyear].pollution()), 90, 230);
			text(states[8][cyear].state() +" | "+ String.format("%.3f",(float)states[8][cyear].hpi()/states[8][cyear].pollution()), 300, 230);
			text(states[9][cyear].state() +" | "+ String.format("%.3f",(float)states[9][cyear].hpi()/states[9][cyear].pollution()), 510, 230);
			text(states[10][cyear].state() +" | "+ String.format("%.3f",(float)states[10][cyear].hpi()/states[10][cyear].pollution()), 720, 230);
			text(states[11][cyear].state() +" | "+ String.format("%.3f",(float)states[11][cyear].hpi()/states[11][cyear].pollution()), 930, 230);
			text(states[12][cyear].state() +" | "+ String.format("%.3f",(float)states[12][cyear].hpi()/states[12][cyear].pollution()), 1140, 230);
			text(states[13][cyear].state() +" | "+ String.format("%.3f",(float)states[13][cyear].hpi()/states[13][cyear].pollution()), 1360, 230);
			text(states[14][cyear].state() +" | "+ String.format("%.3f",(float)states[14][cyear].hpi()/states[14][cyear].pollution()), 90, 305);
			text(states[15][cyear].state() +" | "+ String.format("%.3f",(float)states[15][cyear].hpi()/states[15][cyear].pollution()), 300, 305);
			text(states[16][cyear].state() +" | "+ String.format("%.3f",(float)states[16][cyear].hpi()/states[16][cyear].pollution()), 510, 305);
			text(states[17][cyear].state() +" | "+ String.format("%.3f",(float)states[17][cyear].hpi()/states[17][cyear].pollution()), 720, 305);
			text(states[18][cyear].state() +" | "+ String.format("%.3f",(float)states[18][cyear].hpi()/states[18][cyear].pollution()), 930, 305);
			text(states[19][cyear].state() +" | "+ String.format("%.3f",(float)states[19][cyear].hpi()/states[19][cyear].pollution()), 1140, 305);
			text(states[20][cyear].state() +" | "+ String.format("%.3f",(float)states[20][cyear].hpi()/states[20][cyear].pollution()), 1360, 305);
			text(states[21][cyear].state() +" | "+ String.format("%.3f",(float)states[21][cyear].hpi()/states[21][cyear].pollution()), 90, 380);
			text(states[22][cyear].state() +" | "+ String.format("%.3f",(float)states[22][cyear].hpi()/states[22][cyear].pollution()), 300, 380);
			text(states[23][cyear].state() +" | "+ String.format("%.3f",(float)states[23][cyear].hpi()/states[23][cyear].pollution()), 510, 380);
			text(states[24][cyear].state() +" | "+ String.format("%.3f",(float)states[24][cyear].hpi()/states[24][cyear].pollution()), 720, 380);
			text(states[25][cyear].state() +" | "+ String.format("%.3f",(float)states[25][cyear].hpi()/states[25][cyear].pollution()), 930, 380);
			text(states[26][cyear].state() +" | "+ String.format("%.3f",(float)states[26][cyear].hpi()/states[26][cyear].pollution()), 1140, 380);
			text(states[27][cyear].state() +" | "+ String.format("%.3f",(float)states[27][cyear].hpi()/states[27][cyear].pollution()), 1360, 380);
			text(states[28][cyear].state() +" | "+ String.format("%.3f",(float)states[28][cyear].hpi()/states[28][cyear].pollution()), 90, 455);
			text(states[29][cyear].state() +" | "+ String.format("%.3f",(float)states[29][cyear].hpi()/states[29][cyear].pollution()), 300, 455);
			text(states[30][cyear].state() +" | "+ String.format("%.3f",(float)states[30][cyear].hpi()/states[30][cyear].pollution()), 510, 455);
			text(states[31][cyear].state() +" | "+ String.format("%.3f",(float)states[31][cyear].hpi()/states[31][cyear].pollution()), 720, 455);
			text(states[32][cyear].state() +" | "+ String.format("%.3f",(float)states[32][cyear].hpi()/states[32][cyear].pollution()), 930, 455);
			text(states[33][cyear].state() +" | "+ String.format("%.3f",(float)states[33][cyear].hpi()/states[33][cyear].pollution()), 1140, 455);
			text(states[34][cyear].state() +" | "+ String.format("%.3f",(float)states[34][cyear].hpi()/states[34][cyear].pollution()), 1360, 455);
			text(states[35][cyear].state() +" | "+ String.format("%.3f",(float)states[35][cyear].hpi()/states[35][cyear].pollution()), 90, 530);
			text(states[36][cyear].state() +" | "+ String.format("%.3f",(float)states[36][cyear].hpi()/states[36][cyear].pollution()), 300, 530);
			text(states[37][cyear].state() +" | "+ String.format("%.3f",(float)states[37][cyear].hpi()/states[37][cyear].pollution()), 510, 530);
			text(states[38][cyear].state() +" | "+ String.format("%.3f",(float)states[38][cyear].hpi()/states[38][cyear].pollution()), 720, 530);
			text(states[39][cyear].state() +" | "+ String.format("%.3f",(float)states[39][cyear].hpi()/states[39][cyear].pollution()), 930, 530);
			text(states[40][cyear].state() +" | "+ String.format("%.3f",(float)states[40][cyear].hpi()/states[40][cyear].pollution()), 1140, 530);
			text(states[41][cyear].state() +" | "+ String.format("%.3f",(float)states[41][cyear].hpi()/states[41][cyear].pollution()), 1360, 530);
			text(states[42][cyear].state() +" | "+ String.format("%.3f",(float)states[42][cyear].hpi()/states[42][cyear].pollution()), 90, 605);
			text(states[43][cyear].state() +" | "+ String.format("%.3f",(float)states[43][cyear].hpi()/states[43][cyear].pollution()), 300, 605);
			text(states[44][cyear].state() +" | "+ String.format("%.3f",(float)states[44][cyear].hpi()/states[44][cyear].pollution()), 510, 605);
			text(states[45][cyear].state() +" | "+ String.format("%.3f",(float)states[45][cyear].hpi()/states[45][cyear].pollution()), 720, 605);
			text(states[46][cyear].state() +" | "+ String.format("%.3f",(float)states[46][cyear].hpi()/states[46][cyear].pollution()), 930, 605);
			text(states[47][cyear].state() +" | "+ String.format("%.3f",(float)states[47][cyear].hpi()/states[47][cyear].pollution()), 1140, 605);
			text(states[48][cyear].state() +" | "+ String.format("%.3f",(float)states[48][cyear].hpi()/states[48][cyear].pollution()), 1360, 605);
			text(states[49][cyear].state() +" | "+ String.format("%.3f",(float)states[49][cyear].hpi()/states[49][cyear].pollution()), 90, 680);
			
		}
		
		
	
	}
	//sets the location of all states lat and long 
	public void setlocations() {
		 AK = new Location(states[0][cyear].lat(),states[0][cyear].lng());
		AKMarker = new SimplePointMarker(AK);
		 AL = new Location(states[1][cyear].lat(),states[1][cyear].lng());
		ALMarker = new SimplePointMarker(AL);
		AR = new Location(states[2][cyear].lat(),states[2][cyear].lng());
		ARMarker = new SimplePointMarker(AR);
		 AZ = new Location(states[3][cyear].lat(),states[3][cyear].lng());
		AZMarker = new SimplePointMarker(AZ);
		 CA = new Location(states[4][cyear].lat(),states[4][cyear].lng());
		CAMarker = new SimplePointMarker(CA);
		 CO = new Location(states[5][cyear].lat(),states[5][cyear].lng());
		COMarker = new SimplePointMarker(CO);
		 CT = new Location(states[6][cyear].lat(),states[6][cyear].lng());
		CTMarker = new SimplePointMarker(CT);
		 DE = new Location(states[7][cyear].lat(),states[7][cyear].lng());
		DEMarker = new SimplePointMarker(DE);
		 FL = new Location(states[8][cyear].lat(),states[8][cyear].lng());
		FLMarker = new SimplePointMarker(FL);
		 GA = new Location(states[9][cyear].lat(),states[9][cyear].lng());
		GAMarker = new SimplePointMarker(GA);
		 HI = new Location(states[10][cyear].lat(),states[10][cyear].lng());
		HIMarker = new SimplePointMarker(HI);
		 IA = new Location(states[11][cyear].lat(),states[11][cyear].lng());
		IAMarker = new SimplePointMarker(IA);
		 ID = new Location(states[12][cyear].lat(),states[12][cyear].lng());
		IDMarker = new SimplePointMarker(ID);
		 IL = new Location(states[13][cyear].lat(),states[13][cyear].lng());
		ILMarker = new SimplePointMarker(IL);
		 IN = new Location(states[14][cyear].lat(),states[14][cyear].lng());
		INMarker = new SimplePointMarker(IN);
		 KS = new Location(states[15][cyear].lat(),states[15][cyear].lng());
		KSMarker = new SimplePointMarker(KS);
		 KY =new Location(states[16][cyear].lat(),states[16][cyear].lng());
		KYMarker = new SimplePointMarker(KY);
		 LA = new Location(states[17][cyear].lat(),states[17][cyear].lng());
		LAMarker = new SimplePointMarker(LA);
		 MA = new Location(states[18][cyear].lat(),states[18][cyear].lng());
		MAMarker = new SimplePointMarker(MA);
		 MD = new Location(states[19][cyear].lat(),states[19][cyear].lng());
		MDMarker = new SimplePointMarker(MD);
		 ME = new Location(states[20][cyear].lat(),states[20][cyear].lng());
		MEMarker = new SimplePointMarker(ME);
		 MI = new Location(states[21][cyear].lat(),states[21][cyear].lng());
		MIMarker = new SimplePointMarker(MI);
		 MN = new Location(states[22][cyear].lat(),states[22][cyear].lng());
		MNMarker = new SimplePointMarker(MN);
		 MO = new Location(states[23][cyear].lat(),states[23][cyear].lng());
		MOMarker = new SimplePointMarker(MO);
		 MS = new Location(states[24][cyear].lat(),states[24][cyear].lng());
		MSMarker = new SimplePointMarker(MS);
		 MT = new Location(states[25][cyear].lat(),states[25][cyear].lng());
		MTMarker = new SimplePointMarker(MT);
		 NC = new Location(states[26][cyear].lat(),states[26][cyear].lng());
		NCMarker = new SimplePointMarker(NC);
		 ND = new Location(states[27][cyear].lat(),states[27][cyear].lng());
		NDMarker = new SimplePointMarker(ND);
		 NE =new Location(states[28][cyear].lat(),states[28][cyear].lng());
		NEMarker = new SimplePointMarker(NE);
		 NH =new Location(states[29][cyear].lat(),states[29][cyear].lng());
		NHMarker = new SimplePointMarker(NH);
		 NJ =new Location(states[30][cyear].lat(),states[30][cyear].lng());
		NJMarker = new SimplePointMarker(NJ);
		 NM =new Location(states[31][cyear].lat(),states[31][cyear].lng());
		NMMarker = new SimplePointMarker(NM);
		 NV = new Location(states[32][cyear].lat(),states[32][cyear].lng());
		NVMarker = new SimplePointMarker(NV);
		 NY = new Location(states[33][cyear].lat(),states[33][cyear].lng());
		NYMarker = new SimplePointMarker(NY);
		 OH = new Location(states[34][cyear].lat(),states[34][cyear].lng());
		OHMarker = new SimplePointMarker(OH);
		 OK = new Location(states[35][cyear].lat(),states[35][cyear].lng());
		OKMarker = new SimplePointMarker(OK);
		 OR = new Location(states[36][cyear].lat(),states[36][cyear].lng());
		ORMarker = new SimplePointMarker(OR);
		 PA = new Location(states[37][cyear].lat(),states[37][cyear].lng());
		PAMarker = new SimplePointMarker(PA);
		 RI = new Location(states[38][cyear].lat(),states[38][cyear].lng());
		RIMarker = new SimplePointMarker(RI);
		 SC = new Location(42.755966 ,-107.30249 );
		SCMarker = new SimplePointMarker(SC);
		 SD = new Location(states[40][cyear].lat(),states[40][cyear].lng());
		SDMarker = new SimplePointMarker(SD);
		 TN = new Location(states[41][cyear].lat(),states[41][cyear].lng());
		TNMarker = new SimplePointMarker(TN);
		 TX = new Location(states[42][cyear].lat(),states[42][cyear].lng());
		TXMarker = new SimplePointMarker(TX); 
		 UT = new Location(states[43][cyear].lat(),states[43][cyear].lng());
		UTMarker = new SimplePointMarker(UT);
		 VA = new Location(states[44][cyear].lat(),states[44][cyear].lng());
		VAMarker = new SimplePointMarker(VA);
		 VT = new Location(states[45][cyear].lat(),states[45][cyear].lng());
		VTMarker = new SimplePointMarker(VT);
		 WA = new Location(states[46][cyear].lat(),states[46][cyear].lng());
		WAMarker = new SimplePointMarker(WA);
		 WI =new Location(states[47][cyear].lat(),states[47][cyear].lng());
		WIMarker = new SimplePointMarker(WI);
		 WV =new Location(states[48][cyear].lat(),states[48][cyear].lng());
		WVMarker = new SimplePointMarker(WV);
		WY = new Location(states[49][cyear].lat(),states[49][cyear].lng());
		WYMarker = new SimplePointMarker(WY);	
		
		
	}
	// normalize value for the heat map circle colours takes in the hpi/population for a given state 
	public int normailze(double d) {
		int A = 7;
		int B = 3;
	    int a = 250;
		int b = 10;
		
		return (int) abs(Math.round(a + (d - A)*(b - a)/(B - A)));
		
		
	}
	// normalize value for the heat map circle size takes in the hpi/population for a given state 
	public int normailze2(double d) {
		int A = 7;
		int B = 3;
	    int a = 100;
		int b = 25;
		
		return (int) abs(Math.round(a + (d - A)*(b - a)/(B - A)));
		
		
	}
	// reads data and creates 2d list of state objects rows being the 50 states and columns being the different years for each state
	public void readfile() {
		BufferedReader br = null;
	    String line = "";
	    String splits = ",";
	    int col= -1;
		int row = 0;
		
        try {
			br = new BufferedReader(new FileReader("data.csv"));
			line = br.readLine();
        while ((line = br.readLine()) != null) {
        		
                String[] info = line.split(splits);
                if(info[0].equals("Alabama")) {
                	col++;

                	row = 0;
                	
                }
                
                states[row][col] = new State(Double.parseDouble(info[1]), Double.parseDouble(info[2]), info[0], Double.parseDouble(info[3]), Double.parseDouble(info[4]), Integer.parseInt(info[5]), Integer.parseInt(info[6])); 
                row++;
                
            }
         br.close();
		} catch (IllegalArgumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
		
		}
	}
	// sorts states based on hpi/population value
	public void sort() {
		State newlist[] = new State[50];
		for (int i = 0 ; i < 50; i++) {
			newlist[i] = states[i][cyear];
		}
		MergeSort.sort(newlist);
		for (int i = 0 ; i < 50; i++) {
			states[i][cyear] = newlist[i];
		}
		
	}

	// displays interface
	public static void main(String args[]) {

		PApplet.main(new String[] { MapInterface.class.getName()});
		

	}
	

		

}

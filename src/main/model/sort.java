//package model;
//
//import java.util.ArrayList;
//
//public class sort extends Plants {
//
//	public ArrayList<Plants> SelectPlant(String light, String water, String color) {
//		ArrayList<Plants> answer = new ArrayList<Plants>();
//		ArrayList<Plants> tmp = new ArrayList<Plants>();
//		GardenModel.UpdatePlant();
//		for (Plants i : GardenModel.UpdatePlant()) {
//			if (answer.isEmpty() && (i.light.equals(light) && i.water.equals(water) && i.bloomcolor.equals(color))) {
//				answer.add(i);
//				tmp.add(i);
//			} else {
//				if (i.light.equals(light) && i.water.equals(water) && i.bloomcolor.equals(color)) {
//					for (Plants j : tmp) {
//						if (j.light.equals(i.light) && j.water.equals(i.water) && j.bloomtime.equals(i.bloomtime)
//								&& j.bloomcolor.equals(i.bloomcolor)) {
//						} else {
//							answer.add(i);
//						}
//					}
//					tmp.add(i);
//				}
//			}
//
//		}
//		return answer;
//	}
//
//}

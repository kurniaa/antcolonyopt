package de.jungblut.antcolony;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import de.jungblut.antcolony.AntColonyOptimization.Record;

public class SolutionReader {

  public static void main(String[] args) throws NumberFormatException,
      IOException {
    final BufferedReader br = new BufferedReader(new FileReader(new File(
        "files/heidelberg.tsp")));

    final ArrayList<Record> records = new ArrayList<Record>();

    String line;
    while ((line = br.readLine()) != null) {
      String[] split = line.split(" ");
      records.add(new AntColonyOptimization.Record(
          Double.parseDouble(split[0]), Double.parseDouble(split[1])));
    }

    br.close();

    double distance = 0.0d;
    for (int i = 0; i < records.size() - 1; i++) {
      Record r = records.get(i);
      Record h = records.get(i + 1);
      distance += calculateEuclidianDistance(r.x, r.y, h.x, h.y);
    }

    Record r = records.get(records.size() - 1);
    Record h = records.get(0);
    distance += calculateEuclidianDistance(r.x, r.y, h.x, h.y);

    System.out.println("Optimal distance is: " + distance);
  }

  private static final double calculateEuclidianDistance(double x1, double y1,
      double x2, double y2) {
    double d = (Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    System.out.println(x1 + "/" + y1 + " : " + x2 + "/" + y2 + " = " + d);
    return d;
  }

}

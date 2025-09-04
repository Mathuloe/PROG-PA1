/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tvseriesmanagement;

/**
 *
 * @author Thabang Mathuloe
 */
import java.util.ArrayList;

public class SeriesService {
    private final ArrayList<SeriesModel> seriesList = new ArrayList<>();

    public void captureSeries(SeriesModel series) {
        seriesList.add(series);
    }

    public SeriesModel searchSeries(String id) {
        for (SeriesModel s : seriesList) {
            if (s.seriesID.equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    public boolean updateSeries(String id, String newName, int newAge, int newEpisodes) {
        SeriesModel series = searchSeries(id);
        if (series != null) {
            series.seriesName = newName;
            series.ageRestriction = newAge;
            series.episodes = newEpisodes;
            return true;
        }
        return false;
    }

    public boolean deleteSeries(String id) {
        SeriesModel series = searchSeries(id);
        if (series != null) {
            seriesList.remove(series);
            return true;
        }
        return false;
    }

    public ArrayList<SeriesModel> getAllSeries() {
        return seriesList;
    }

    public String seriesReport() {
        if (seriesList.isEmpty()) {
            return "No series available in the system.";
        }
        StringBuilder report = new StringBuilder();
        for (SeriesModel series : seriesList) {
            report.append(series.toString())
                  .append("\n-----------------------------\n");
        }
        return report.toString();
    }
}

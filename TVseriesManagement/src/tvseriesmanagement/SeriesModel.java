/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tvseriesmanagement;

/**
 *
 * @author Thabang Mathuloe
 */
public class SeriesModel {
    public String seriesID;
    public String seriesName;
    public int ageRestriction;
    public int seasons;
    public int episodes;

    public SeriesModel(String seriesID, String seriesName, int ageRestriction, int seasons, int episodes) {
        this.seriesID = seriesID;
        this.seriesName = seriesName;
        this.ageRestriction = ageRestriction;
        this.seasons = seasons;
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return "SERIES ID: " + seriesID +
                "\nSERIES NAME: " + seriesName +
                "\nAGE RESTRICTION: " + ageRestriction +
                "\nNUMBER OF SEASONS: " + seasons +
                "\nNUMBER OF EPISODES: " + episodes;
    }
}


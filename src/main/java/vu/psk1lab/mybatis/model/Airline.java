package vu.psk1lab.mybatis.model;

import java.util.List;

public class Airline {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.AIRLINE.AIRLINE_ID
     *
     * @mbg.generated Wed May 04 14:54:36 EEST 2022
     */
    private Integer airlineId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.AIRLINE.AIRLINE_NAME
     *
     * @mbg.generated Wed May 04 14:54:36 EEST 2022
     */
    private String airlineName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.AIRLINE.AIRLINE_ID
     *
     * @return the value of PUBLIC.AIRLINE.AIRLINE_ID
     *
     * @mbg.generated Wed May 04 14:54:36 EEST 2022
     */
    public Integer getAirlineId() {
        return airlineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.AIRLINE.AIRLINE_ID
     *
     * @param airlineId the value for PUBLIC.AIRLINE.AIRLINE_ID
     *
     * @mbg.generated Wed May 04 14:54:36 EEST 2022
     */
    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.AIRLINE.AIRLINE_NAME
     *
     * @return the value of PUBLIC.AIRLINE.AIRLINE_NAME
     *
     * @mbg.generated Wed May 04 14:54:36 EEST 2022
     */
    public String getAirlineName() {
        return airlineName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.AIRLINE.AIRLINE_NAME
     *
     * @param airlineName the value for PUBLIC.AIRLINE.AIRLINE_NAME
     *
     * @mbg.generated Wed May 04 14:54:36 EEST 2022
     */
    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    private List<Plane> planeList;

    private List<Pilot> pilotList;



}
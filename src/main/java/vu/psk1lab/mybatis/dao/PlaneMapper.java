package vu.psk1lab.mybatis.dao;

import java.util.List;

import org.mybatis.cdi.Mapper;
import vu.psk1lab.mybatis.model.Airline;
import vu.psk1lab.mybatis.model.Pilot;
import vu.psk1lab.mybatis.model.Plane;

@Mapper
public interface PlaneMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLANE
     *
     * @mbg.generated Wed May 04 14:54:36 EEST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLANE
     *
     * @mbg.generated Wed May 04 14:54:36 EEST 2022
     */
    int insert(Plane record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLANE
     *
     * @mbg.generated Wed May 04 14:54:36 EEST 2022
     */
    Plane selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLANE
     *
     * @mbg.generated Wed May 04 14:54:36 EEST 2022
     */
    List<Plane> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLANE
     *
     * @mbg.generated Wed May 04 14:54:36 EEST 2022
     */
    int updateByPrimaryKey(Plane record);

    Airline getPlaneAirlines(Integer id);

    List<Pilot> selectPilotsForPlanes(Integer id);
}
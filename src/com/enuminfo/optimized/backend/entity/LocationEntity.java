/**
 * 
 */
package com.enuminfo.optimized.backend.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.enuminfo.optimized.backend.ColumnType;
import com.enuminfo.optimized.backend.TableType;

/**
 * @author Kumar
 */
@Entity
@Table(name = TableType.LOCATION)
@NamedQueries({ @NamedQuery(name = LocationEntity.FIND_ALL, query = "SELECT entity FROM LocationEntity entity"),
		@NamedQuery(name = LocationEntity.FIND_BY_NAME, query = "SELECT entity FROM LocationEntity entity WHERE entity.name LIKE :name") })
@AttributeOverride(name = ColumnType.ID, column = @Column(name = ColumnType.ID))
public class LocationEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String FIND_ALL = "Location.FindAll";
	public static final String FIND_BY_NAME = "Location.FindByName";

	@Column(name = ColumnType.NAME)
	private String name;

	@Column(name = ColumnType.PIN)
	private Long pin;

	@Column(name = ColumnType.CITY)
	private String city;

	@Column(name = ColumnType.STATE)
	private String state;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = ColumnType.COUNTRY)
	private CountryEntity country;

	public LocationEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPin() {
		return pin;
	}

	public void setPin(Long pin) {
		this.pin = pin;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(CountryEntity country) {
		this.country = country;
	}
}

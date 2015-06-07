package medical;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BodyState")
public class BodyState {
	
	private int ID;
	private int measurement;
	private int date;
	private final BodyStateType type;
	
	public BodyState(BodyStateType type) {
		this.type = type;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public int getMeasurement() {
		return measurement;
	}
	public void setMeasurement(int measurement) {
		this.measurement = measurement;
	}
	public BodyStateType getType() {
		return type;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	
	
	
}

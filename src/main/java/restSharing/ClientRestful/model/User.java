package restSharing.ClientRestful.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String surname;
	
	@Column(name="user_code")
	private String userCode;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	@Column(name="birth_place")
	private String birthPlace;
	
	private String gender;
	
	@Column(name="fiscal_code")
	private String fiscalCode;
	
	private String address;
	
	@Column(name="zip_code")
	private int zipCode;
	
	private String city;
	
	private String province;
	
	@JsonIgnore
	@OneToOne(mappedBy="user",cascade=CascadeType.ALL)
	private Account account;
	
}

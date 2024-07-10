package restSharing.ClientRestful.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name="accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String username;
	
	private String email;
	
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_user", referencedColumnName = "id")
	private User user;
}

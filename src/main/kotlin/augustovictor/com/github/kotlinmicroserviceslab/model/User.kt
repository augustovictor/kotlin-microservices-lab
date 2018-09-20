package augustovictor.com.github.kotlinmicroserviceslab.model

import javax.persistence.*

@Entity
class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = 0,

        @Column(name = "first_name")
        val firstName: String = "",

        @Column(name = "last_name")
        val lastName: String = ""
)
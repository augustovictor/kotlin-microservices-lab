package augustovictor.com.github.kotlinmicroserviceslab.model

import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = 0,

        @NotNull
        @field:Size(min = 2)
        @Column(name = "first_name")
        val firstName: String = "",

        @NotNull
        @field:Size(min = 2, max = 10)
        @Column(name = "last_name")
        val lastName: String = ""
)
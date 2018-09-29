package augustovictor.com.github.kotlinmicroserviceslab.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Post(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = 0,
        val title: String = "",
        val description: String = ""
) {
        @ManyToOne(fetch = FetchType.LAZY)
        @JsonIgnore
        lateinit var user: User
}
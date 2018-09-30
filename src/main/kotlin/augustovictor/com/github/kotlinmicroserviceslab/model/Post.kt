package augustovictor.com.github.kotlinmicroserviceslab.model

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity
data class Post(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = 0,
        val title: String = "",
        val description: String = ""
) {
        @ManyToOne(fetch = FetchType.LAZY)
        @JsonBackReference
        lateinit var user: User
}
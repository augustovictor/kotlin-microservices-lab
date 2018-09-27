package augustovictor.com.github.kotlinmicroserviceslab.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@ApiModel(description = "This user is a customer from the system.")
@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Int = 0,

        @ApiModelProperty(notes = "Should have at least 2 characters")
        @NotNull
        @field:Size(min = 2)
        @Column(name = "first_name")
        val firstName: String = "",

        @ApiModelProperty(notes = "Should have at least 2 characters")
        @NotNull
        @field:Size(min = 2, max = 10)
        @Column(name = "last_name")
        val lastName: String = ""
)
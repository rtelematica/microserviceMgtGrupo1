@Controller
public class AlumnosController{
	
	@GetMapping("/")
	@ResponseBody
	public String helloSpringCLI(){
		return "Hola Mundo Spring Boot CLI";
	}
}

package freemarker;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import person.Person;

public class FreemarkerRender {
	public static void main(String[] args) throws IOException, TemplateException {
		Configuration config = new Configuration(Configuration.VERSION_2_3_27);
		config.setDirectoryForTemplateLoading(new File("src/freemarker"));
		Template temp = config.getTemplate("template.ftl");
		Map<String, Object> models = new HashMap<String, Object>();
		Person person1 = new Person("dany", "ss", 23);
		models.put("person", person1);
		temp.process(models, new OutputStreamWriter(System.out));
	}

}

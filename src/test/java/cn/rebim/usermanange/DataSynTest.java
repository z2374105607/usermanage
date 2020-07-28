package cn.rebim.usermanange;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.adc.da.usermanage.Application;
import com.adc.da.usermanage.service.DataSynchronizationBatchService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
@AutoConfigureMockMvc
public class DataSynTest {
	
	@Autowired
	private DataSynchronizationBatchService dataSynchronizationBatchService;

	@Test
	public void getCasesTest() throws Exception {

		//this.mockMvc.perform(get("/getFClassess")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void fclassinsertTeat() {
		dataSynchronizationBatchService.dataSynchronization();
	}
}

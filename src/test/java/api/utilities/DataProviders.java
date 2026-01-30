package api.utilities;

import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name="Data")
	public String[][] getAllData()throws IOException{
		String path=System.getProperty("D://Eclipse-Workspace//RestAssured//TestData//testdata1.xlsx");
		testUtilities xl=new testUtilities(path);
		int rownum=xl.getRowCount("Sheet1");
		int colcount=xl.getCellCount("Sheet1",1);
		
		String apidata[][]=new String [rownum][colcount];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<=colcount;j++) {
				apidata[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		return apidata;
	}
	
	@DataProvider(name="UserNames")
	public String[] getUserNames()throws IOException{
		String path=System.getProperty("D://Eclipse-Workspace//RestAssured//TestData//testdata1.xlsx");
		testUtilities xl=new testUtilities(path);
		int rownum=xl.getRowCount("Sheet1");
		
		String[] username=new String[rownum];
		for(int i=1;i<=rownum;i++) {
			username[i-1]=xl.getCellData("Sheet1", i,1);
		}
        for(int i=0;i< username.length;i++){
            System.out.println("Username found from test data::"+username[i]);
        }
		return username;
	}

    @DataProvider(name="firstName")
    public String[] getfirstName() throws IOException {
        String filepath = System.getProperty("D://Eclipse-Workspace//RestAssured//TestData//testdata1.xlsx");
        testUtilities excelfile=new testUtilities(filepath);
        int rowcount=excelfile.getRowCount("Sheet1");
        String[] firstName=new String[rowcount];
        for(int i=1;i<=rowcount;i++) {
            firstName[i-1]=excelfile.getCellData("Sheet1", i,2);
        }
        for(int i=0;i< firstName.length;i++){
            System.out.println("Username found from test data::"+firstName[i]);
        }
        return firstName;
    }
}

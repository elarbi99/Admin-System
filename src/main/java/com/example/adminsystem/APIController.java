package com.example.adminsystem;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;


public class APIController {

    // The API Controller is where all information and connection code for connecting
    // to the shop API

    private String id;
    private String itemId;
    private String addUserName;
    private String newId;
    private String fName;
    private String lName;
    private String position;
    private LocalDate doh;
    private String phone;
    private String altPhone;
    private String emergencyContact;
    private String emergencyContactPhone;
    private String emergencyContact2;
    private String emergencyContactPhone2;
    private Double payRate;
    private LocalDate terminationDate;
    private String roles;
    private String password;
    private String newPassword;
    private String email;
    private String updatedPassword;
    private String item;
    private double onHand;
    private double price;
    private String description;
    private  String tempMessage;
    private static int empID;
    private String userID;
    private static String token;
    private String timeCardError;
    private List<String>employeeIDList=new ArrayList<>();
    private List<String>fNameList=new ArrayList<>();
    private List<String>lNameList=new ArrayList<>();
    private List<String>positionList=new ArrayList<>();
    private List<String>dohList=new ArrayList<>();
    private List<String>emailList=new ArrayList<>();
    private List<String>phoneList=new ArrayList<>();
    private List<String>phoneList2=new ArrayList<>();
    private List<String>emergencyContactList=new ArrayList<>();
    private List<String>emergencyContactListPhone=new ArrayList<>();
    private List<String>emergencyContactList2=new ArrayList<>();
    private List<String>emergencyContactListPhone2=new ArrayList<>();
    private List<String>payRateList=new ArrayList<>();
    private static List<String>productIdList=new ArrayList<>();
    private static List<String>itemList=new ArrayList<>();
    private static List<String>onHandList=new ArrayList<>();
    private static List<String>priceList=new ArrayList<>();
    private static List<String>descriptionList=new ArrayList<>();
    private int timeCardID;
    private static List<String>timeCardIdList=new ArrayList<>();
    private static List<String>timeCardFNameList=new ArrayList<>();
    private static List<String>timeCardLNameList=new ArrayList<>();
    private static List<String>timeCardPositionList=new ArrayList<>();
    private static List<String>punchInList=new ArrayList<>();
    private static List<String>punchOutList=new ArrayList<>();
    private static List<String>punchStartMealList=new ArrayList<>();
    private static List<String>punchEndMealList=new ArrayList<>();
    private static List<String>timeCardDate=new ArrayList<>();
    private static List<String>subtotalList=new ArrayList<>();
    private static List<String> orderIDList =new ArrayList<>();
    private static List<String>totalList=new ArrayList<>();
    private static List<String>discountList=new ArrayList<>();
    private static List<String>OrderDateList=new ArrayList<>();
    public static List<String> getTimeCardFNameList() {
        return timeCardFNameList;
    }

    public static void setTimeCardFNameList(List<String> timeCardFNameList) {
        APIController.timeCardFNameList = timeCardFNameList;
    }

    public static List<String> getTimeCardLNameList() {
        return timeCardLNameList;
    }

    public static void setTimeCardLNameList(List<String> timeCardLNameList) {
        APIController.timeCardLNameList = timeCardLNameList;
    }

    public static List<String> getTimeCardPositionList() {
        return timeCardPositionList;
    }

    public static void setTimeCardPositionList(List<String> timeCardPositionList) {
        APIController.timeCardPositionList = timeCardPositionList;
    }

    public static List<String> getPunchInList() {
        return punchInList;
    }

    public static void setPunchInList(List<String> punchInList) {
        APIController.punchInList = punchInList;
    }

    public static List<String> getPunchOutList() {
        return punchOutList;
    }

    public static void setPunchOutList(List<String> punchOutList) {
        APIController.punchOutList = punchOutList;
    }

    public static List<String> getPunchStartMealList() {
        return punchStartMealList;
    }

    public static void setPunchStartMealList(List<String> punchStartMealList) {
        APIController.punchStartMealList = punchStartMealList;
    }

    public static List<String> getPunchEndMealList() {
        return punchEndMealList;
    }

    public static void setPunchEndMealList(List<String> punchEndMealList) {
        APIController.punchEndMealList = punchEndMealList;
    }

    public static List<String> getTimeCardDate() {
        return timeCardDate;
    }

    public static void setTimeCardDate(List<String> timeCardDate) {
        APIController.timeCardDate = timeCardDate;
    }

    public static List<String> getTimeCardIdList() {
        return timeCardIdList;
    }

    public static void setTimeCardIdList(List<String> timeCardIdList) {
        APIController.timeCardIdList = timeCardIdList;
    }

    public static List<String> getOrderIDList() {
        return orderIDList;
    }

    public static void setOrderIDList(List<String> orderIDList) {
        APIController.orderIDList = orderIDList;
    }

    public static List<String> getSubtotalList() {
        return subtotalList;
    }

    public static void setSubtotalList(List<String> subtotalList) {
        APIController.subtotalList = subtotalList;
    }

    public static List<String> getTotalList() {
        return totalList;
    }

    public static void setTotalList(List<String> totalList) {
        APIController.totalList = totalList;
    }

    public static List<String> getDiscountList() {
        return discountList;
    }

    public static void setDiscountList(List<String> discountList) {
        APIController.discountList = discountList;
    }

    public static List<String> getOrderDateList() {
        return OrderDateList;
    }

    public static void setOrderDateList(List<String> orderDateList) {
        OrderDateList = orderDateList;
    }

    public  String getTimeCardError() {
        return timeCardError;
    }

    public void login() throws IOException {

        // Establish parameters needed to make connection to API/server
        String stringUrl = "https://cis294.hfcc.edu/api/user/login";
        String json = "{\"username\" :\"" + id + "\", \"password\" :\"" + password + "\"}";
        JSONObject obj = new JSONObject();
        URL url = new URL(stringUrl);

        // Create Http connection to API
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8"); // uses JSON as the content type (important)
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST"); // connection will use the POST method

        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes(StandardCharsets.UTF_8));
        os.close(); // closes OutputStream obj (important)

        // Creates InputStream to get the result and turn it into a String
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = IOUtils.toString(in, StandardCharsets.UTF_8);
        System.out.println(result);

        JSONObject myResponse = new JSONObject(result);
        tempMessage = myResponse.getString("message");
        token=myResponse.getString("token");
        empID=myResponse.getInt("id");
        System.out.println(tempMessage); // print tempMessage out to console
        in.close(); // closes InputStream (important)
        conn.disconnect(); // disconnect connection
    } // end login method
    public void punchLogin() throws IOException {

        // Establish parameters needed to make connection to API/server
        String stringUrl = "https://cis294.hfcc.edu/api/user/login";
        String json = "{\"username\" :\"" + id + "\", \"password\" :\"" + password + "\"}";
        JSONObject obj = new JSONObject();
        URL url = new URL(stringUrl);

        // Create Http connection to API
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8"); // uses JSON as the content type (important)
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST"); // connection will use the POST method

        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes(StandardCharsets.UTF_8));
        os.close(); // closes OutputStream obj (important)

        // Creates InputStream to get the result and turn it into a String
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = IOUtils.toString(in, StandardCharsets.UTF_8);
        System.out.println(result);

        JSONObject myResponse = new JSONObject(result);
        tempMessage = myResponse.getString("message");
        token=myResponse.getString("token");
        empID=myResponse.getInt("id");
        System.out.println(tempMessage); // print tempMessage out to console
        in.close(); // closes InputStream (important)
        conn.disconnect(); // disconnect connection
    }
    public void addNewEmployee() throws IOException {
        String stringUrl = "https://cis294.hfcc.edu/api/employee/add";
        System.out.println(newId);
        System.out.println(token);
        String json = "{\"first_name\" :\""+fName+"\", \"last_name\" :\""+ lName+ "\",\"position\" :\""+position+"\", \"hire_date\" :\""+doh+"\" , \"email\" :\""+email+"\", \"cell_phone\" :\""+phone+"\", \"pay_rate\" :"+payRate+", \"username\" :\""+addUserName+"\", \"password\" :\""+newPassword+"\",\"roles\" : [\"ROLE_USER\",\"ROLE_ADMIN\"],  \"alt_phone\" :\""+altPhone+"\", \"emergency_contact_1\" : \""+emergencyContact+"\", \"phone_emergency_contact_1\" :\""+emergencyContactPhone+"\", \"emergency_contact_2\" :\""+emergencyContact2+"\", \"phone_emergency_contact_2\" :\""+emergencyContactPhone2+"\"}";
        URL url = new URL(stringUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Authorization","Bearer "+token);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = IOUtils.toString(in, "UTF-8");
        System.out.println(result);
        JSONObject myResponse = new JSONObject(result);
        in.close();
        conn.disconnect();
    }
    public void updateEmployee() throws IOException {
        String stringUrl = "https://cis294.hfcc.edu/api/employee/update";
        System.out.println(newId);
        System.out.println(token);
        String json = "{\"employee_id\" :"+newId+", \"last_name\" :\""+ lName+ "\", \"position\" :\""+ position+ "\",\"termination_date\" :\""+terminationDate+"\", \"cell_phone\" :\""+phone+"\" , \"alt_phone\" :\""+altPhone+"\", \"emergency_contact_1\" :\""+emergencyContact+"\", \"phone_emergency_contact_1\" :\""+emergencyContactPhone+"\", \"emergency_contact_2\" :\""+emergencyContact2+"\", \"phone_emergency_contact_2\" :\""+emergencyContactPhone2+"\", \"pay_rate\" :"+payRate+"}";
        URL url = new URL(stringUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Authorization","Bearer "+token);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = IOUtils.toString(in, "UTF-8");
        System.out.println(result);
        JSONObject myResponse = new JSONObject(result);
        in.close();
        conn.disconnect();
    }
    public void displayOrders() throws IOException {
        String stringUrl = "https://cis294.hfcc.edu/api/order/get_all";
        String json = "{}";
        URL url = new URL(stringUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Authorization","Bearer "+token);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = IOUtils.toString(in, "UTF-8");
        System.out.println(result);
        JSONObject myResponse = new JSONObject(result);
        JSONObject agac = myResponse.getJSONObject("data");
        System.out.println(agac);
        JSONArray agac2 = agac.getJSONArray("orders");
        System.out.println(agac2);

        for(int i=0; i<=agac2.length()-1;i++)
        {
            JSONObject agac3 =agac2.getJSONObject(i);
            orderIDList.add(String.valueOf(agac3.getInt("id")));
            discountList.add(String.valueOf(agac3.getDouble("discount")));
            subtotalList.add(String.valueOf(agac3.getDouble("subtotal")));
            totalList.add(String.valueOf(agac3.getDouble("total")));
            getOrderDateList().add(agac3.getString("order_date_time"));
        }
        System.out.println(orderIDList);
        System.out.println(discountList);


        in.close();
        conn.disconnect();
    }
    public void addProduct() throws IOException {
        String stringUrl = "https://cis294.hfcc.edu/api/product/add";
        System.out.println(token);
        String json = "{\"name\" :\""+item+"\", \"price\" :\""+ price+ "\", \"description\" : \""+description+"\", \"quant_in_stock\" :\""+ onHand+"\" }";
        URL url = new URL(stringUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Authorization","Bearer "+token);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = IOUtils.toString(in, "UTF-8");
        System.out.println(result);
        JSONObject myResponse = new JSONObject(result);
        in.close();
        conn.disconnect();
    }
    public void removeProduct() throws IOException {
        String stringUrl = "https://cis294.hfcc.edu/api/product/delete";
        System.out.println(newId);
        System.out.println(token);
        String json = "{\"prod_id\" :\""+itemId+"\"}";
        URL url = new URL(stringUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Authorization","Bearer "+token);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = IOUtils.toString(in, "UTF-8");
        System.out.println(result);
        JSONObject myResponse = new JSONObject(result);
        in.close();
        conn.disconnect();
    }
    public void updateProduct() throws IOException {
        String stringUrl = "https://cis294.hfcc.edu/api/product/update";
        System.out.println(newId);
        System.out.println(token);
        String json = "{\"prod_id\" :\""+itemId+"\", \"quant_in_stock\" :\""+ onHand+ "\", \"price\" :\""+ price+"\" }";
        URL url = new URL(stringUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Authorization","Bearer "+token);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = IOUtils.toString(in, "UTF-8");
        System.out.println(result);
        in.close();
        conn.disconnect();
    }
    public void updatePassword() throws IOException {
        String stringUrl = "https://cis294.hfcc.edu/api/user/update";
        String json = "{\"id\" :\""+userID+"\", \"password\" :\""+ updatedPassword+ "\", \"roles\":[]}";
        URL url = new URL(stringUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Authorization","Bearer "+token);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = IOUtils.toString(in, "UTF-8");
        System.out.println(result);
        in.close();
        conn.disconnect();
    }
    public void displayProducts() throws IOException {
        String stringUrl = "https://cis294.hfcc.edu/api/product/get_all";
        String json = "{}";
        URL url = new URL(stringUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Authorization","Bearer "+token);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = IOUtils.toString(in, "UTF-8");
        System.out.println(result);
        JSONObject myResponse = new JSONObject(result);

        JSONObject agac = myResponse.getJSONObject("data");
        System.out.println(agac);
        JSONArray agac2 = agac.getJSONArray("products");
        System.out.println(agac2.length());
        for(int i=0; i<=agac2.length()-1;i++)
        {
            JSONObject agac3 =agac2.getJSONObject(i);
            productIdList.add(String.valueOf(agac3.getInt("id")));
            itemList.add(agac3.getString("name"));
            priceList.add(String.valueOf(agac3.getDouble("price")));
            onHandList.add(String.valueOf(agac3.getInt("quant_in_stock")));
            descriptionList.add(agac3.getString("description"));
        }
        System.out.println(productIdList);
        System.out.println(itemList);
        System.out.println(priceList);
        System.out.println(onHandList);
        System.out.println(descriptionList);


        in.close();
        conn.disconnect();
    }
    public void displayEmployeeData() throws IOException {
        String stringUrl = "https://cis294.hfcc.edu/api/employee/get_all";
        String json = "{}";
        URL url = new URL(stringUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Authorization","Bearer "+token);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = IOUtils.toString(in, "UTF-8");
        System.out.println(result);
        JSONObject myResponse = new JSONObject(result);
        JSONObject agac = myResponse.getJSONObject("data");
        System.out.println(agac);
        JSONArray agac2 = agac.getJSONArray("employees");
        System.out.println(agac2);

        for(int i=0; i<=agac2.length()-1;i++)
        {
            JSONObject agac3 =agac2.getJSONObject(i);

            if(i>4){

                employeeIDList.add(String.valueOf(agac3.getInt("id")));
                fNameList.add(agac3.getString("firstName"));
                lNameList.add(agac3.getString("lastName"));
                positionList.add(agac3.getString("position"));
                dohList.add(agac3.getString("hireDate"));
                emailList.add(agac3.getString("email"));
                phoneList.add(agac3.getString("cellPhone"));
                phoneList2.add(agac3.getString("altPhone"));
                emergencyContactList.add(agac3.getString("emergencyContact_1"));
                emergencyContactListPhone.add(agac3.getString("phoneEmergencyContact_1"));
                emergencyContactList2.add(agac3.getString("emergencyContact_2"));
                emergencyContactListPhone2.add(agac3.getString("phoneEmergencyContact_2"));
                payRateList.add(agac3.getString("payRate"));
                JSONObject agac4 =agac3.getJSONObject("user");


            }

        }


        System.out.println(employeeIDList);
        System.out.println(phoneList2);


        in.close();
        conn.disconnect();
    }

    public void clockIn() throws IOException {
        String stringUrl = "https://cis294.hfcc.edu/api/employee/clock_in";
        //empID=empID-5;
        String json = "{\"employee_id\" :\""+empID+"\"}";
        URL url = new URL(stringUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Authorization","Bearer "+token);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = IOUtils.toString(in, "UTF-8");
        System.out.println(result);
        JSONObject myResponse = new JSONObject(result);
        if(myResponse.has("error"))
        {
            timeCardError=myResponse.getString("error");
        }
        in.close();
        conn.disconnect();
    }
    public void clockOut() throws IOException {
        String stringUrl = "https://cis294.hfcc.edu/api/employee/clock_out";
        //empID=empID-5;
        String json = "{\"employee_id\" :\""+empID+"\"}";
        URL url = new URL(stringUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Authorization","Bearer "+token);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = IOUtils.toString(in, "UTF-8");
        System.out.println(result);
        JSONObject myResponse = new JSONObject(result);
        if(myResponse.has("error"))
        {
            timeCardError=myResponse.getString("error");
        }
        in.close();
        conn.disconnect();
    }
    public void lunchStart() throws IOException {
        String stringUrl = "https://cis294.hfcc.edu/api/employee/lunch_start";
        //empID=empID-5;
        String json = "{\"employee_id\" :\""+empID+"\"}";
        URL url = new URL(stringUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Authorization","Bearer "+token);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = IOUtils.toString(in, "UTF-8");
        System.out.println(result);
        JSONObject myResponse = new JSONObject(result);;
        if(myResponse.has("error"))
        {
            timeCardError=myResponse.getString("error");
        }
        in.close();
        conn.disconnect();
    }
    public void lunchEnd() throws IOException {
        String stringUrl = "https://cis294.hfcc.edu/api/employee/lunch_end";
        //empID=empID-5;
        String json = "{\"employee_id\" :\""+empID+"\"}";
        URL url = new URL(stringUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Authorization","Bearer "+token);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = IOUtils.toString(in, "UTF-8");
        System.out.println(result);
        JSONObject myResponse = new JSONObject(result);
        if(myResponse.has("error"))
        {
            timeCardError=myResponse.getString("error");
        }
        in.close();
        conn.disconnect();
    }
    public void setTimeCardError(String timeCardError){this.timeCardError=timeCardError;}
    public void displayEmployeeTimecard() throws IOException {
        String stringUrl = "https://cis294.hfcc.edu/api/employee/get_emp_timecards";
        String json = "{\"employee_id\" :\""+timeCardID+"\"}";
        URL url = new URL(stringUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Authorization","Bearer "+token);
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
        OutputStream os = conn.getOutputStream();
        os.write(json.getBytes("UTF-8"));
        os.close();
        InputStream in = new BufferedInputStream(conn.getInputStream());
        String result = IOUtils.toString(in, "UTF-8");
        System.out.println(result);
        JSONObject myResponse = new JSONObject(result);

        JSONObject agac = myResponse.getJSONObject("data");
        System.out.println(agac);

        JSONArray agac2 = agac.getJSONArray("timecards");
        System.out.println(agac2);

        for(int i=0; i<=agac2.length()-1;i++)
        {
            JSONObject agac3 =agac2.getJSONObject(i);
            JSONObject agac4 = agac3.getJSONObject("employee");
            timeCardIdList.add(String.valueOf(agac3.getInt("id")));
            timeCardFNameList.add(agac4.getString("firstName"));
            timeCardLNameList.add(agac4.getString("lastName"));
            timeCardPositionList.add(agac4.getString("position"));
            punchInList.add(agac3.getString("start_date"));
            if(agac3.isNull("end_date"))
            {
                punchOutList.add("");
            }
            else if(!agac3.isNull("end_date")) {
                punchOutList.add(agac3.getString("end_date"));
            }
            if(agac3.isNull("lunch_start"))
            {
                punchStartMealList.add("");
            }
            else if(!agac3.isNull("lunch_start")) {
                punchStartMealList.add(agac3.getString("lunch_start"));
            }
            if(agac3.isNull("lunch_end"))
            {
                punchEndMealList.add("");
            }
            else if (!agac3.isNull("lunch_end")){
                punchEndMealList.add(agac3.getString("lunch_end"));
            }

            timeCardDate.add(agac3.getString("schedule_date"));
        }
        System.out.println(punchInList);
        System.out.println(timeCardFNameList);

        in.close();
        conn.disconnect();
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    public List<String>getEmployeeIDList(){return employeeIDList;}
    public List<String>getfNameList(){return fNameList;}
    public List<String>getlNameList(){return lNameList;}
    public List<String>getPositionList(){return positionList;}
    public List<String>getEmailList(){return emailList;}
    public List<String>getPhoneList(){return phoneList;}
    public List<String>getPhoneList2(){return phoneList2;}
    public List<String>getEmergencyContactList(){return emergencyContactList;}
    public List<String>getEmergencyContactListPhone(){return emergencyContactListPhone;}
    public List<String>getDohList(){return dohList;}
    public List<String>getEmergencyContactList2(){return emergencyContactList2;}
    public List<String>getEmergencyContactListPhone2(){return emergencyContactListPhone2;}
    public List<String>getPayRateList(){return payRateList;}
    public void setNewId(String newId) {
        this.newId = newId;
    }

    public void setfName(String fName){this.fName=fName;}
    public List<String>getItemList(){return itemList;}
    public List<String>getPriceList(){return priceList;}
    public List<String>getOnHandList(){return onHandList;}
    public List<String>getDescriptionList(){return descriptionList;}
    public List<String>getProductIdList(){return productIdList;}
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email){this.email=email;}
    public void setNewPassword(String newPassword) {
        this.newPassword= newPassword;
    }
    public void setItem(String item){this.item=item;}
    public void setOnHand(int onHand){this.onHand=onHand;}
    public void setPrice(double price){this.price=price;}
    public void setDescription(String description){this.description=description;}
    public String getTempMessage() { return tempMessage; }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDoh(LocalDate doh) {
        this.doh = doh;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAltPhone(String altPhone) {
        this.altPhone = altPhone;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    public void setEmergencyContact2(String emergencyContact2) {
        this.emergencyContact2 = emergencyContact2;
    }

    public void setEmergencyContactPhone2(String emergencyContactPhone2) {
        this.emergencyContactPhone2 = emergencyContactPhone2;
    }

    public void setPayRate(Double payRate) {
        this.payRate = payRate;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public LocalDate getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(LocalDate terminationDate) {
        this.terminationDate = terminationDate;
    }

    public void setTimeCardID(int timeCardID) {
        this.timeCardID = timeCardID;
    }

    public void setUpdatedPassword(String updatedPassword) {
        this.updatedPassword = updatedPassword;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAddUserName() {
        return addUserName;
    }

    public void setAddUserName(String addUserName) {
        this.addUserName = addUserName;
    }
} // end of class

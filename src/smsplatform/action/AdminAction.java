package smsplatform.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import smsplatform.dao.TBdMessagesend;
import smsplatform.dao.TBdMessagesendgroup;
import smsplatform.dao.TBdRechargeandconsumption;
import smsplatform.dao.TBdUser;
import smsplatform.domain.Page;
import smsplatform.service.AdminService;
import smsplatform.service.LogService;
import smsplatform.service.UserService;

public class AdminAction {
	public Page<TBdUser> userPage;
	public Page<TBdMessagesend> msgsendPage;
	public Page<TBdMessagesendgroup> msgGrouPage;
	public Page<TBdRechargeandconsumption> consumPage;
	
	
	
	public List<TBdUser> tBdUsers;
	public TBdUser tBdUser;
	public TBdMessagesendgroup tBdMessagesendgroup;
	public List<TBdMessagesend> tBdMessagesends; // 查询发送短信
	public List<TBdMessagesendgroup> tBdMessagesendgroups;
	private List<TBdRechargeandconsumption> tBdRechargeandconsumptions;
	public int userID;
	public int money;
	public String result;
	/**
	 * 修改扣量比
	 * @return
	 */
	public String updateDeduct(){
		JSONObject json = new JSONObject();
		AdminService adminService = new AdminService();
		try {
			if (adminService.updateDeduct(tBdUser)) {
				 result = json.accumulate("message", "1").toString();
			}else {
				 result = json.accumulate("message", "0").toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.accumulate("message", "0"); // 失败
			result = json.toString();
		}
	   
		return "success";
	}

	public String findallgroupMsg() {
		JSONObject json = new JSONObject();
		JsonConfig config = new JsonConfig();
		AdminService adminService = new AdminService();
		tBdMessagesendgroups = adminService.findallgroupMsg();

		config.setExcludes(new String[] { "TBdMessagesends",
				"TBdMessagesendgroups", "TBdRechargeandconsumptions",
				"TBdLogs", "handler", "hibernateLazyInitializer" });
		result = JSONArray.fromObject(tBdMessagesendgroups.toArray(), config)
				.toString();

		Long uid = (Long) ActionContext.getContext().getSession().get("uid");
		LogService.getInstance().log(uid, "查询所有短信分組");
		return "success";
	}

	/**
	 * 查询每个分组每条发送短信状态及消息
	 * 
	 * @return
	 */

	public String findallSendMsg() {
		String msg = "1";
		JSONObject json = new JSONObject();
		JsonConfig config = new JsonConfig();
		AdminService adminService = new AdminService();
		try {
			tBdMessagesends = adminService.findallSendMsg(tBdMessagesendgroup);
			config.setExcludes(new String[] { "TBdMessagesendgroup" });// 除去emps属性
			// json.fromObject(msg).toString();
			result = JSONArray.fromObject(tBdMessagesends, config).toString();

		} catch (Exception e) {
			e.printStackTrace();
			msg = "0";
			result = json.fromObject(msg).toString();
			return "fail";
		}
		Long uid = (Long) ActionContext.getContext().getSession()
		.get("uid");
		LogService.getInstance().log(uid,
				"查询所有短信组" + tBdMessagesendgroup.getFSendGroupId() + "消息");

		return "success";

	}

	/*
	 * public String findallSendMsg(){ String msg = "1"; JSONObject json=new
	 * JSONObject(); try { AdminService adminService = new AdminService();
	 * tBdMessagesends = adminService.findallSendMsg(tBdMessagesendgroup);
	 * JsonConfig config = new JsonConfig(); // JSONObject json=new
	 * JSONObject(); json.accumulate("message", msg);
	 * result=json.toString()+JSONArray.fromObject(tBdMessagesends,
	 * config).toString();
	 * 
	 * Long uid = (Long) ActionContext.getContext().getSession().get("uid");
	 * LogService.getInstance().log(uid,
	 * "查询分組"+tBdMessagesendgroup.getFSendGroupId()+"所有短信"); } catch (Exception
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); msg ="0";
	 * json.accumulate("message", msg); result=json.toString(); } return
	 * "success";
	 * 
	 * }
	 */
	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	public String findAllUser() {
		JSONObject json = new JSONObject();
		try {

			AdminService adminService = new AdminService();
			tBdUsers = adminService.findAllUser();
			JsonConfig config = new JsonConfig();
			config.setExcludes(new String[] { "TBdMessagesendgroups",
					"TBdRechargeandconsumptions", "TBdLogs" });// 除去emps属性
			result = JSONArray.fromObject(tBdUsers, config).toString();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			json.accumulate("message", "0"); // 失败
			result = json.toString();
			return "fail";
		}
		return "success";
	}

	/**
	 * 查询用户信息
	 * 
	 * @return
	 */
	public String findUser() {
		try {
			AdminService userService = new AdminService();
			userPage.setRecords(userService.getScrollData(userPage
					.getMaxresult(), userPage.getCurrentpage()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "fail";
		}
		Long uid = (Long) ActionContext.getContext().getSession().get("uid");
		LogService.getInstance().log(uid, "查询所有用户");
		return "success";
	}

	/**
	 * 用户充值（用户名，充值金额）
	 * 
	 * @return
	 */
	public String recharge() {
		// JSONObject json=new JSONObject();
		String msg;
		JSONObject json = new JSONObject();
		Long uid = (Long) ActionContext.getContext().getSession().get("uid");
		LogService.getInstance().log(uid, "充值---");
		try {
			AdminService adminService = new AdminService();
			adminService.recharge(userID, money);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			json.accumulate("message", "0"); // 失败
			result = json.toString();
			return "fail";
		}

		json.accumulate("message", "1"); // 成功
		result = json.toString();

		LogService.getInstance().log(uid, Long.valueOf(userID),
				"给用户ID：?，充值金额：" + money);
		return "success";
	}

	public String findRechargeComsumption() {
		String msg = "1";
		JSONObject json = new JSONObject();
		JsonConfig config = new JsonConfig();
		AdminService adminService = new AdminService();
		Long uid = (Long) ActionContext.getContext().getSession().get("uid");
		try {
			tBdRechargeandconsumptions = adminService.findRechargeComsumption();
		} catch (Exception e) {
			e.printStackTrace();
			msg = "0";
			result = json.fromObject(msg).toString();
			return "fail";
		}

		config.setExcludes(new String[] { "TBdMessagesends",
				"TBdMessagesendgroups", "TBdRechargeandconsumptions",
				"TBdLogs", "handler", "hibernateLazyInitializer" });
		result = JSONArray.fromObject(tBdRechargeandconsumptions, config)
				.toString();
		return "success";
	}

	public Page<TBdUser> getUserPage() {
		return userPage;
	}

	public void setUserPage(Page<TBdUser> userPage) {
		this.userPage = userPage;
	}

	public Page<TBdMessagesend> getMsgsendPage() {
		return msgsendPage;
	}

	public void setMsgsendPage(Page<TBdMessagesend> msgsendPage) {
		this.msgsendPage = msgsendPage;
	}

	public Page<TBdMessagesendgroup> getMsgGrouPage() {
		return msgGrouPage;
	}

	public void setMsgGrouPage(Page<TBdMessagesendgroup> msgGrouPage) {
		this.msgGrouPage = msgGrouPage;
	}

	public Page<TBdRechargeandconsumption> getConsumPage() {
		return consumPage;
	}

	public void setConsumPage(Page<TBdRechargeandconsumption> consumPage) {
		this.consumPage = consumPage;
	}

	public List<TBdUser> gettBdUsers() {
		return tBdUsers;
	}

	public void settBdUsers(List<TBdUser> tBdUsers) {
		this.tBdUsers = tBdUsers;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public TBdUser gettBdUser() {
		return tBdUser;
	}

	public void settBdUser(TBdUser tBdUser) {
		this.tBdUser = tBdUser;
	}

	public TBdMessagesendgroup gettBdMessagesendgroup() {
		return tBdMessagesendgroup;
	}

	public void settBdMessagesendgroup(TBdMessagesendgroup tBdMessagesendgroup) {
		this.tBdMessagesendgroup = tBdMessagesendgroup;
	}

	public List<TBdMessagesend> gettBdMessagesends() {
		return tBdMessagesends;
	}

	public void settBdMessagesends(List<TBdMessagesend> tBdMessagesends) {
		this.tBdMessagesends = tBdMessagesends;
	}

	public List<TBdMessagesendgroup> gettBdMessagesendgroups() {
		return tBdMessagesendgroups;
	}

	public void settBdMessagesendgroups(
			List<TBdMessagesendgroup> tBdMessagesendgroups) {
		this.tBdMessagesendgroups = tBdMessagesendgroups;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}

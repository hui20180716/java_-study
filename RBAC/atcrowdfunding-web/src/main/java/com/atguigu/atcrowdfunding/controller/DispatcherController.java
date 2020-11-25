package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.AJAXResult;
import com.atguigu.atcrowdfunding.bean.Permission;
import com.atguigu.atcrowdfunding.bean.User;
import com.atguigu.atcrowdfunding.service.PermissionService;
import com.atguigu.atcrowdfunding.service.UserService;

@Controller
public class DispatcherController {

	@Autowired
	private UserService userService;
	@Autowired
	private PermissionService permissionService;
	
	@RequestMapping("/login")
	public String login() {
		List<User> dbUser = userService.queryAll();
		System.out.println(dbUser.size());
		return "login";
	}
	
	@RequestMapping("/error")
	public String error() {
		return "error";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//session.removeAttribute("loginUser");
		session.invalidate();
		return "redirect:login";
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@ResponseBody
	@RequestMapping("/doAJAXLogin")
	public Object doAJAXLogin(User user, HttpSession session) {
		
		AJAXResult result = new AJAXResult();
		
		User dbUser = userService.query4Login(user);
		if ( dbUser != null ) {
			session.setAttribute("loginUser", dbUser);
			
			// 鑾峰彇鐢ㄦ埛鏉冮檺淇℃伅
			List<Permission> permissions = permissionService.queryPermissionsByUser(dbUser);
			Map<Integer, Permission> permissionMap = new HashMap<Integer, Permission>();
			Permission root = null;
			Set<String> uriSet = new HashSet<String>();
			for ( Permission permission : permissions ) {
				permissionMap.put(permission.getId(), permission);
				if ( permission.getUrl() != null && !"".equals(permission.getUrl()) ) {
					uriSet.add(session.getServletContext().getContextPath() + permission.getUrl());
				}
			}
			session.setAttribute("authUriSet", uriSet);
			for ( Permission permission : permissions ) {
				Permission child = permission;
				if ( child.getPid() == 0 ) {
					root = permission;
				} else {
					Permission parent = permissionMap.get(child.getPid());
					parent.getChildren().add(child);
				}
			}
			session.setAttribute("rootPermission", root);
			result.setSuccess(true);
		} else {
			result.setSuccess(false);
		}
		
		return result;
	}
	
	/**
	 * 鎵ц鐧婚檰
	 * @return
	 */
	@RequestMapping("/doLogin")
	public String doLogin( User user, Model model ) throws Exception {
		
		String loginacct = user.getLoginacct();
		
		// 灏嗕贡鐮佸瓧绗︿覆鎸夌収閿欒鐨勭紪鐮佹柟寮忚浆鎹负鍘熷鐨勫瓧鑺傜爜搴忓垪
		//byte[] bs = loginacct.getBytes("ISO8859-1");
		
		// 灏嗗師濮嬬殑瀛楄妭鐮佸簭鍒楁寜鐓ф纭殑缂栫爜杞崲涓烘纭殑鏂囧瓧鍗冲彲銆�
		//loginacct = new String(bs, "UTF-8");
		
		
		// 1) 鑾峰彇琛ㄥ崟鏁版嵁
		// 1-1) HttpServletRequest
		// 1-2) 鍦ㄦ柟娉曞弬鏁板垪琛ㄤ腑澧炲姞琛ㄥ崟瀵瑰簲鐨勫弬鏁帮紝鍚嶇О鐩稿悓
		// 1-3) 灏辨槸灏嗚〃鍗曟暟鎹皝瑁呬负瀹炰綋绫诲璞�
		
		// 2) 鏌ヨ鐢ㄦ埛淇℃伅
		User dbUser = userService.query4Login(user);
		
		// 3) 鍒ゆ柇鐢ㄦ埛淇℃伅鏄惁瀛樺湪
		if ( dbUser != null ) {
			// 鐧婚檰鎴愬姛锛岃烦杞埌涓婚〉闈�
			return "main";
		} else {
			// 鐧婚檰澶辫触锛岃烦杞洖鍒扮櫥闄嗛〉闈紝鎻愮ず閿欒淇℃伅
			String errorMsg = "鐧婚檰璐﹀彿鎴栧瘑鐮佷笉姝ｇ‘锛岃閲嶆柊杈撳叆";
			model.addAttribute("errorMsg", errorMsg);
			return "redirect:login";
		}
		
		
	}
}

/**
 * 
 */
package com.coral.cstore;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.coral.cstore.cache.IconCache;
import com.coral.cstore.utils.ImageUtils;
import com.coral.cstore.utils.MessageCenter;
import com.coral.cstore.utils.StrUtils;
import com.coral.fundation.rules.LoginRule;
import com.coral.fundation.service.UserService;
import com.coral.fundation.user.UserModel;

/**
 * @author coral.ma
 *
 */
public class Login {
	
	private IconCache iconCache = new IconCache();
	Display display;
	Shell shell;
	Button loginBtn;
	Label closeBtn;
	
	Text userNameText;
	Text pwText;
	
	public static void main (String [] args) {
		Display display = new Display ();
		Login login = new Login();
		Shell shell = login.open(display);
		while (! shell.isDisposed()) {
			if (! display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public Shell open(Display display) {
		this.display = display;
		iconCache.initResources(display);
		ImageUtils.setIconCache(iconCache);
		shell = new Shell (display, SWT.NO_TRIM);
		initLoginPanel();
		bind();
		shell.setLocation(display.getClientArea().width / 2 - shell.getSize().x/2, display
                .getClientArea().height / 2 - shell.getSize().y/2);
		shell.setBackground(Style.white);
		shell.setMaximized(false);
		shell.open();
		return shell;
	}
	
	public void initLoginPanel() {
		final Image image = ImageUtils.getImage("loginBiz");
		Region region = new Region();
		final ImageData imageData = image.getImageData();
		if (imageData.alphaData != null) {
			Rectangle pixel = new Rectangle(0, 0, 1, 1);
			for (int y = 0; y < imageData.height; y++) {
				for (int x = 0; x < imageData.width; x++) {
					if (imageData.getAlpha(x, y) == 255) {
						pixel.x = imageData.x + x;
						pixel.y = imageData.y + y;
						region.add(pixel);
					} 
				}
			}
		} else {
			ImageData mask = imageData.getTransparencyMask();
			Rectangle pixel = new Rectangle(0, 0, 1, 1);
			for (int y = 0; y < mask.height; y++) {
				for (int x = 0; x < mask.width; x++) {
					if (mask.getPixel(x, y) != 0) {
						pixel.x = imageData.x + x;
						pixel.y = imageData.y + y;
						region.add(pixel);
					}
				}
			}
		}
		shell.setRegion(region);

		Listener l = new Listener() {
			int startX, startY;
			public void handleEvent(Event e)  {
				if (e.type == SWT.KeyDown && e.character == SWT.ESC) {
					shell.dispose();
				}
				if (e.type == SWT.MouseDown && e.button == 1) {
					startX = e.x;
					startY = e.y; 
				}
				if (e.type == SWT.MouseMove && (e.stateMask & SWT.BUTTON1) != 0) {
					Point p = shell.toDisplay(e.x, e.y);
					p.x -= startX;
					p.y -= startY;
					shell.setLocation(p);
				}
				if (e.type == SWT.Paint) {
					e.gc.drawImage(image, imageData.x, imageData.y);
				}
			}
		};
		shell.addListener(SWT.KeyDown, l);
		shell.addListener(SWT.MouseDown, l);
		shell.addListener(SWT.MouseMove, l);
		shell.addListener(SWT.Paint, l);
		layoutLoginPanel();
		shell.setSize(imageData.x + imageData.width, imageData.y + imageData.height);

	}
	
	public void layoutLoginPanel() {
		shell.setLayout(new FormLayout());
		FormData userFormData = new FormData(215,25);
		userFormData.left = new FormAttachment(16);
	    userFormData.top = new FormAttachment(32);
		userNameText = new Text(shell, SWT.SINGLE | SWT.BORDER);
		userNameText.setFont(Style.loginInputFont);
		userNameText.setLayoutData(userFormData);
		userNameText.setText("coral");
		
		FormData pwFormData = new FormData(215,25);
		pwFormData.left = new FormAttachment(16);
		pwFormData.top = new FormAttachment(50);
		pwText = new Text(shell, SWT.SINGLE | SWT.BORDER | SWT.PASSWORD);
		pwText.setText("110");
//		pwText.setFont(Style.loginInputFont);
		pwText.setLayoutData(pwFormData);
		
		FormData lbFormData = new FormData();
		lbFormData.left = new FormAttachment(36);
		lbFormData.top = new FormAttachment(72);
		loginBtn = new Button(shell, SWT.PUSH);
		loginBtn.setLayoutData(lbFormData);
		loginBtn.setImage(ImageUtils.getImage("loginBtn"));
		
		FormData cbFormData = new FormData();
		cbFormData.left = new FormAttachment(96);
		cbFormData.top = new FormAttachment(0);
		closeBtn = new Label(shell, SWT.None);
		closeBtn.setLayoutData(cbFormData);
		closeBtn.setImage(ImageUtils.getImage("closeWinBtn"));
		
	}

	public void bind() {
		loginBtn.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				login();
			}
		});
		userNameText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(e.character == SWT.CR) {
					if(LoginRule.isCorrectInput(userNameText.getText(), pwText.getText())) {
						login();
					}
				}
			}
		});
		pwText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(e.character == SWT.CR) {
					if(LoginRule.isCorrectInput(userNameText.getText(), pwText.getText())) {
						login();
					}
				}
			}
		});
		closeBtn.addMouseListener(new MouseAdapter() {
			public void mouseUp(MouseEvent e) {
				shell.close();
			}
		});
	}
	
	public void login() {
		UserService service = new UserService();
		UserModel userModel = service.login(userNameText.getText(), pwText.getText());
		if(userModel != null) {
			shell.close();
			CStore cStore = new CStore();
			cStore.setUserModel(userModel);
			cStore.runCStore(display);
		} else {
			MessageCenter.alertMessage(shell, StrUtils.getResourceString("login.failMessage")).open();
		}
	}
}

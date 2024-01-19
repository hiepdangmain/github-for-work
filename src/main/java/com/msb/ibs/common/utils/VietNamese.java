
package com.msb.ibs.common.utils;

import java.text.Normalizer;

public class VietNamese {
	static  char mang[][]=new char[][]
	                               {
	                                   {'À','Á','Ả','Ã','Ạ','Â','Ấ','Ầ','Ẩ','Ẫ','Ậ','Ắ','Ằ','Ă','Ặ'},//0
	                                   {'Đ'},//1
	                                   {'È','É','Ẻ','Ẽ','Ẹ','Ê','Ề','Ế','Ể','Ễ','Ệ'},//2
	                                   {'Ì','Í','Ỉ','Ĩ','Ị'},//3
	                                   {'Ò','Ó','Ỏ','Õ','Ọ','Ô','Ồ','Ố','Ổ','Ỗ','Ộ','Ơ','Ờ','Ớ','Ở','Ỡ','Ợ'},
	                                   {'Ù','Ú','Ủ','Ũ','Ụ','Ư','Ừ','Ứ','Ử','Ữ','Ự'},
	                                   {'Ỳ','Ý','Ỷ','Ỹ','Ỵ'},
	                                   {'à','á','ả','ã','ạ','â','ấ','ầ','ẩ','ẫ','ậ','ắ','ằ','ă','ặ'},
	                                   {'đ'},
	                                   {'è','é','ẻ','ẽ','ẹ','ê','ề','ế','ể','ễ','ệ'},
	                                   {'ì','í','ỉ','ĩ','ị'},
	                                   {'ò','ó','ỏ','õ','ọ','ô','ồ','ố','ổ','ỗ','ộ','ơ','ờ','ớ','ở','ỡ','ợ'},
	                                   {'ù','ú','ủ','ũ','ụ','ư','ừ','ứ','ử','ữ','ự'},
	                                   {'ỳ','ý','ỷ','ỹ','ỵ'},
	                                   {'\r','\n'}
	                                
	                               };
               static  char[] mangR=new char[]{'A','D','E','I','O','U','Y','a','d','e','i','o','u','y',' '}; 
               static  char[] mangTtr=new char[]{'A','D','E','I','O','U','Y','a','d','e','i','o','u','y',' '};
               
               public static char search(char x){        
                   for(int u=0;u<mang.length;u++)
                    for (int v=0;v<mang[u].length;v++)                        
                        if (x==mang[u][v])
                            return mangR[u];
                   return x;
               }
               
               public static char searchTtr(char x){        
                   for(int u=0;u<mang.length;u++)
                    for (int v=0;v<mang[u].length;v++)                        
                        if (x==mang[u][v])
                            return mangTtr[u];
                        else if (x=='\n')
                   			return '\n';
                   return x;
               }
               
               public static String clearVNSql(String s){
            	   if(s==null||s.length()==0){
            		   return "";
            	   }
            	   s = Normalizer.normalize(s, Normalizer.Form.NFC);
                   String temp="";        
                   for(int i=0;i<s.length();i++)                           
                           temp+=search(s.charAt(i));                           
                   return temp.replaceAll("[^a-zA-Z0-9&@\\-/!$%\\’&()_+/?., ]+", "").trim();   
                   //~!@#$%^&*()_+:{}'
               }
               
               public static String clearVNBasic(String s){
            	   if(s==null||s.length()==0){
            		   return "";
            	   }
            	   s = Normalizer.normalize(s, Normalizer.Form.NFC);
                   String temp="";        
                   for(int i=0;i<s.length();i++)                           
                           temp+=search(s.charAt(i));                           
                   return temp.replaceAll("[^a-zA-Z0-9&@\\-/!$%\'\\’&()_+/?., ]+", "").trim();   
                   //~!@#$%^&*()_+:{}'
               }
               
               public static String clearVN(String s){
            	   if(s==null||s.length()==0){
            		   return "";
            	   }
            	   s = Normalizer.normalize(s, Normalizer.Form.NFC);
                   String temp="";        
                   for(int i=0;i<s.length();i++)                           
                           temp+=search(s.charAt(i));  
                   
                   return temp.replaceAll("[^a-zA-Z0-9&@\\-/!$%&()_+/?., ]+", "").trim();   
                   //~!@#$%^&*()_+:{}'
               }
               
               public static String clearTtrVN(String s){
            	   if(s==null||s.length()==0){
            		   return "";
            	   }
            	// check xuong dong neu qua 35 ki tu
            	   s = breakLine(s);
            	   s = Normalizer.normalize(s, Normalizer.Form.NFC);
                   String temp="";        
                   for(int i=0;i<s.length();i++)                           
                           temp+=searchTtr(s.charAt(i));
                   if(temp.contains("\n"))
                	   return temp.replaceAll("[^a-zA-Z0-9\n()+:/.,| ]+", "").trim();  
                   else
                	   return temp.replaceAll("[^a-zA-Z0-9()+:/.,| ]+", "").trim();    
                   //~!@#$%^&*()_+:{}'
               }
               
               public static String clearTtrRemarkVN(String s){
            	   if(s==null||s.length()==0){
            		   return "";
            	   }         	              	   
            	   s = Normalizer.normalize(s, Normalizer.Form.NFC);
                   String temp="";        
                   for(int i=0;i<s.length();i++)                           
                           temp+=searchTtr(s.charAt(i));
                  
               return temp.replaceAll("[^a-zA-Z0-9()+:/., ]+", "").trim();  
                
                   //~!@#$%^&*()_+:{}'
               }
               
               public static String clearVNAdvance(String s){
            	   if(s==null||s.length()==0){
            		   return "";
            	   }
            	   s = Normalizer.normalize(s, Normalizer.Form.NFC);
                   String temp="";        
                   for(int i=0;i<s.length();i++)                           
                           temp+=search(s.charAt(i));                           
                   return temp.replaceAll("[^a-zA-Z0-9&@\\-/!$%&()_+/?., ]+", "");   
                   //~!@#$%^&*()_+:{}'
               }
               
           	private static String breakLine(String s) {
        		String result = s.trim();
        		String line1 = "";
        		String line2 = "";
        		if (result.length() > 35 && !result.contains("\n")) {
        			line1 = result.substring(0, 35);
        			line2 = result.substring(35).trim();			
        			result = line1.concat("\n").concat(line2);
        			System.out.println("QuyenCV2_line1 :" + line1);
        			System.out.println("QuyenCV2_line2 :" + line2);
        			System.out.println("QuyenCV2_result :" + result);
        		}
        		return result;
        	}
               
               public static void main(String[] args) {
				// String dd= "THI HONG  NGUYEN ;FLIGHT:1241;DEST:HAN -VDH ;DATE:29/03/2019 08:40 ;EXPDATE:31/01/2019 16:58";
            	// Bo dau ' - 18/01/2021
            	   String dd= "BG180843 CTY CP VNC TT LUONG 12.2020 H' % -BUC AYUN";
				//System.out.println(dd.length());
				//System.out.println(clearVNAdvance(dd));
				// System.out.println(clearVN(dd).length());
				System.out.println(clearVNAdvance(dd));
				//String value="AGRIBANK EA H’LEO";
				//System.out.println("Data: " + clearVN(value));
               }

}

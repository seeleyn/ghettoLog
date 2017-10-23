	public static void ghettoLog(String message) {
		try {
			FileWriter writer = new FileWriter("/tmp/ghetto.log", true);
			PrintWriter printWriter = new PrintWriter(new BufferedWriter(writer));
			printWriter.println(message);
			printWriter.close();
		} catch (Throwable throwable) {
			System.out.println("Error writing to ghetto log");
			throwable.printStackTrace();
		}
	}




	public static void ghettoLog(Throwable throwable) {
		try {
			FileWriter writer = new FileWriter("/tmp/ghetto.log", true);
			PrintWriter printWriter = new PrintWriter(new BufferedWriter(writer));
			throwable.printStackTrace(printWriter);
			printWriter.close();
		} catch (Throwable throwable2) {
			System.out.println("Error writing to ghetto log");
			throwable2.printStackTrace();
		}
	}



	/** Used to log ZMQ json in Insight**/
	public static void ghettoLog(String checkpoint, String zmqJson) {
		if (zmqJson!=null) {
			try {
				Map<String, Object> zmqMessage = new ObjectMapper().readValue(zmqJson, HashMap.class);
				Map body = (Map) zmqMessage.get("body");
				String type = String.valueOf(zmqMessage.get("messageType"));
				String objName = String.valueOf(body.get("name"));
				if ("job".equals(type)) {
					log.error("888888888888888888 check "+checkpoint+", name='"+objName+"', type='"+type+"', json='"+zmqJson.substring(0,50)+"'");
				}
			} catch (IOException e) {
				log.error("8888888888888888 Error parsing json "+zmqJson,e);
			}

		}
	}

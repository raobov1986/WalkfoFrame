/*
 * Copyright 2010-2012 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.raoul.walkfoframe.web;

import android.util.Log;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBScanExpression;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.PaginatedScanList;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.raoul.walkfoframe.HWOFameApplication;
import com.raoul.walkfoframe.model.Questions;
import com.raoul.walkfoframe.model.Quizzes;
import com.raoul.walkfoframe.model.WOFControl;
import com.raoul.walkfoframe.model.WOFCouponCat;
import com.raoul.walkfoframe.model.WOFCoupons;
import com.raoul.walkfoframe.model.WOFMedia;
import com.raoul.walkfoframe.model.WOFPushNotification;
import com.raoul.walkfoframe.model.WOFStars;
import com.raoul.walkfoframe.model.Wofhonorees;

import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class DynamoDBManager {

	public static List<Map<String, AttributeValue>> getUserList() {
		AmazonDynamoDB ddb = HWOFameApplication.clientManager;
		ScanRequest request = new ScanRequest();
		request.setTableName("WOFHonorees");
		try {
			ScanResult result = ddb.scan(request);

			return result.getItems();

		} catch (AmazonServiceException ex) {
			//HWOFameApplication.clientManager.wipeCredentialsOnAuthError(ex);
		}

		return null;
	}

	public static ArrayList<Wofhonorees> getWOFhonorees(Date timestamp) {
		System.out.println("---------    getWOFhonorees called --------   "
				+ HWOFameApplication.clientManager);
		AmazonDynamoDB ddb = null;
		try {
			ddb = HWOFameApplication.clientManager;
			// System.out.println(" AmazonDynamoDB : "+HWOFameApplication.clientManager.ddb());
		} catch (Exception e) {
			System.out
					.println("--------------  exception generate --------------");
			e.printStackTrace();
		}
		System.out
				.println("---------    getWOFhonorees called ddb :--------   "
						+ ddb);
		DynamoDBMapper mapper = new DynamoDBMapper(ddb);

		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
		dateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		long milis = timestamp.getTime();
        String timestampString = dateFormatter.format(milis);
        
        scanExpression.addFilterCondition("datelastupdate", new Condition()
				.withComparisonOperator(ComparisonOperator.GT.toString())
				.withAttributeValueList(new AttributeValue().withN(timestampString)));
        
		try {
			PaginatedScanList<Wofhonorees> result = mapper.scan(
					Wofhonorees.class, scanExpression);

			ArrayList<Wofhonorees> resultList = new ArrayList<Wofhonorees>();
			for (Wofhonorees up : result) {
				resultList.add(up);
			}
			System.out
					.println("---------    getWOFhonorees called return --------   "
							+ resultList);
			return resultList;

		} catch (AmazonServiceException ex) {
			System.out
					.println("---------    getWOFhonorees called Exception generate --------   ");
			//HWOFameApplication.clientManager.wipeCredentialsOnAuthError(ex);
		}
		System.out
				.println("---------    getWOFhonorees called return --------   "
						+ null);
		return null;
	}

	public static ArrayList<WOFStars> GetWofStars(Date timestamp) {
		AmazonDynamoDB ddb = HWOFameApplication.clientManager;
		DynamoDBMapper mapper = new DynamoDBMapper(ddb);

		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
		dateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		long milis = timestamp.getTime();
        String timestampString = dateFormatter.format(milis);
        
        scanExpression.addFilterCondition("datelastupdate", new Condition()
				.withComparisonOperator(ComparisonOperator.GT.toString())
				.withAttributeValueList(new AttributeValue().withN(timestampString)));
		try {
			PaginatedScanList<WOFStars> result = mapper.scan(WOFStars.class,
					scanExpression);

			ArrayList<WOFStars> resultList = new ArrayList<WOFStars>();
			for (WOFStars up : result) {
				resultList.add(up);
			}

			return resultList;

		} catch (AmazonServiceException ex) {
			ex.printStackTrace();
			//HWOFameApplication.clientManager.wipeCredentialsOnAuthError(ex);
		}

		return null;

	}

	public static ArrayList<Questions> GetWofQuestion(Date timestamp) {
		AmazonDynamoDB ddb = HWOFameApplication.clientManager;
		DynamoDBMapper mapper = new DynamoDBMapper(ddb);

		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
		dateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		long milis = timestamp.getTime();
        String timestampString = dateFormatter.format(milis);
        
        scanExpression.addFilterCondition("datelastupdate", new Condition()
				.withComparisonOperator(ComparisonOperator.GT.toString())
				.withAttributeValueList(new AttributeValue().withN(timestampString)));
        
		try {
			PaginatedScanList<Questions> result = mapper.scan(Questions.class,
					scanExpression);

			ArrayList<Questions> resultList = new ArrayList<Questions>();
			for (Questions up : result) {
				resultList.add(up);
			}

			return resultList;

		} catch (AmazonServiceException ex) {
			//HWOFameApplication.clientManager.wipeCredentialsOnAuthError(ex);
		}

		return null;

	}

	public static ArrayList<Quizzes> GetWofQuize(Date timestamp) {
		AmazonDynamoDB ddb = HWOFameApplication.clientManager;
		DynamoDBMapper mapper = new DynamoDBMapper(ddb);
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
		dateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		long milis = timestamp.getTime();
        String timestampString = dateFormatter.format(milis);
        
        scanExpression.addFilterCondition("datelastupdate", new Condition()
				.withComparisonOperator(ComparisonOperator.GT.toString())
				.withAttributeValueList(new AttributeValue().withN(timestampString)));
		try {
			PaginatedScanList<Quizzes> result = mapper.scan(Quizzes.class,
					scanExpression);

			ArrayList<Quizzes> resultList = new ArrayList<Quizzes>();
			for (Quizzes up : result) {
				resultList.add(up);
			}
			
			Log.e("ResultList", resultList.size() + "");

			return resultList;

		} catch (AmazonServiceException ex) {
			//HWOFameApplication.clientManager.wipeCredentialsOnAuthError(ex);
		}

		return null;

	}

	public static ArrayList<WOFControl> GetWofControls() {
		AmazonDynamoDB ddb = HWOFameApplication.clientManager;
		DynamoDBMapper mapper = new DynamoDBMapper(ddb);

		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
		try {
			PaginatedScanList<WOFControl> result = mapper.scan(
					WOFControl.class, scanExpression);

			ArrayList<WOFControl> resultList = new ArrayList<WOFControl>();
			for (WOFControl up : result) {
				resultList.add(up);
			}

			return resultList;

		} catch (AmazonServiceException ex) {
			//HWOFameApplication.clientManager.wipeCredentialsOnAuthError(ex);
		}

		return null;

	}

	public static ArrayList<WOFCoupons> GetWofCoupons() {
		AmazonDynamoDB ddb = HWOFameApplication.clientManager;
		DynamoDBMapper mapper = new DynamoDBMapper(ddb);

		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
		try {
			PaginatedScanList<WOFCoupons> result = mapper.scan(
					WOFCoupons.class, scanExpression);

			ArrayList<WOFCoupons> resultList = new ArrayList<WOFCoupons>();
			for (WOFCoupons up : result) {
				resultList.add(up);
			}

			return resultList;

		} catch (AmazonServiceException ex) {
			//HWOFameApplication.clientManager.wipeCredentialsOnAuthError(ex);
		}

		return null;

	}
	
	public static ArrayList<WOFCouponCat> GetWofCouponsCategories() {
		AmazonDynamoDB ddb = HWOFameApplication.clientManager;
		DynamoDBMapper mapper = new DynamoDBMapper(ddb);

		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
		try {
			PaginatedScanList<WOFCouponCat> result = mapper.scan(
					WOFCouponCat.class, scanExpression);

			ArrayList<WOFCouponCat> resultList = new ArrayList<WOFCouponCat>();
			for (WOFCouponCat up : result) {
				resultList.add(up);
			}

			return resultList;

		} catch (AmazonServiceException ex) {
			//HWOFameApplication.clientManager.wipeCredentialsOnAuthError(ex);
		}

		return null;

	}

	public static ArrayList<WOFMedia> GetWofMedia(Date timestamp) {
		AmazonDynamoDB ddb = HWOFameApplication.clientManager;
		DynamoDBMapper mapper = new DynamoDBMapper(ddb);
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
		dateFormatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		long milis = timestamp.getTime();
        String timestampString = dateFormatter.format(milis);
        
        scanExpression.addFilterCondition("datelastupdate", new Condition()
				.withComparisonOperator(ComparisonOperator.GT.toString())
				.withAttributeValueList(new AttributeValue().withN(timestampString)));
        
		try {
			PaginatedScanList<WOFMedia> result = mapper.scan(WOFMedia.class,
					scanExpression);
			ArrayList<WOFMedia> resultList = new ArrayList<WOFMedia>();
			for (WOFMedia up : result) {
				resultList.add(up);
			}
			return resultList;
		} catch (AmazonServiceException ex) {
			//HWOFameApplication.clientManager.wipeCredentialsOnAuthError(ex);
		}
		return null;

	}
	
	public static ArrayList<WOFPushNotification> getWofPushNotifications(int lastNotificationId) throws UnknownHostException {
		BasicAWSCredentials c = new BasicAWSCredentials("AKIAJRYXOB72QJQU3MQQ", "FOQ6TDEhxTqvZb6hb+5db1OQFd4nikDRh2tuGqy1");
		AmazonDynamoDB clientManager = new AmazonDynamoDBClient(c);
	    clientManager.setRegion(Region.getRegion(Regions.US_WEST_2));
	    
		AmazonDynamoDB ddb = clientManager;
		DynamoDBMapper mapper = new DynamoDBMapper(ddb);
		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression();
        
        scanExpression.addFilterCondition("ID", new Condition()
				.withComparisonOperator(ComparisonOperator.GT.toString())
				.withAttributeValueList(new AttributeValue().withN(lastNotificationId+"")));
		try {
			PaginatedScanList<WOFPushNotification> result = mapper.scan(WOFPushNotification.class,
					scanExpression);

			ArrayList<WOFPushNotification> resultList = new ArrayList<WOFPushNotification>();
			for (WOFPushNotification up : result) {
				resultList.add(up);
			}
			
			Log.e("Push notification result list", resultList.size() + "");

			return resultList;

		} catch (AmazonServiceException ex) {
			//HWOFameApplication.clientManager.wipeCredentialsOnAuthError(ex);
		}

		return null;
	}

}

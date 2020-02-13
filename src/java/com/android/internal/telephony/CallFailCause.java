/*
 * Copyright (C) 2006 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.internal.telephony;

/**
 * Call fail causes from TS 24.008 .
 * These are mostly the cause codes we need to distinguish for the UI.
 * See 22.001 Annex F.4 for mapping of cause codes to local tones.
 *
 * CDMA call failure reasons are derived from the possible call failure scenarios described
 * in "CDMA IS2000 - Release A (C.S0005-A v6.0)" standard.
 *
 * The detailed fail causes are defined in ITU Recommendation Q.850.
 *
 * {@hide}
 *
 */
public interface CallFailCause {
    // The disconnect cause is not valid (Not received a disconnect cause)
    int NOT_VALID = -1;

    // Unassigned/Unobtainable number
    int UNOBTAINABLE_NUMBER = 1;

    int NO_ROUTE_TO_DEST = 3;
    int CHANNEL_UNACCEPTABLE = 6;
    int OPERATOR_DETERMINED_BARRING = 8;
    int NORMAL_CLEARING     = 16;
    int USER_BUSY           = 17;
    int NO_USER_RESPONDING = 18;

    /**
     * This cause is used when the called party has been alerted but does not respond with a connect
     * indication within a prescribed period of time. Note - This cause is not necessarily generated
     * by Q.931 procedures but may be generated by internal network timers.
     */
    int USER_ALERTING_NO_ANSWER = 19;

    /**
     * The equipment sending this cause does not wish to accept this call, although it could have
     * accepted the call because the equipment sending this cause is neither busy nor incompatible.
     * The network may also generate this cause, indicating that the call was cleared due to a
     * supplementary service constraint. The diagnostic field may contain additional information
     * about the supplementary service and reason for rejection.
     */
    int CALL_REJECTED = 21;

    int NUMBER_CHANGED      = 22;
    int PRE_EMPTION = 25;

    // The user has not been awarded the incoming call.
    int NON_SELECTED_USER_CLEARING = 26;

    int DESTINATION_OUT_OF_ORDER = 27;

    // Incomplete number
    int INVALID_NUMBER_FORMAT = 28;

    // Supplementary service requested by the user cannot be provide by the network.
    int FACILITY_REJECTED = 29;

    int STATUS_ENQUIRY      = 30;
    int NORMAL_UNSPECIFIED  = 31;
    int NO_CIRCUIT_AVAIL    = 34;

    // Resource unavailable
    int NETWORK_OUT_OF_ORDER = 38;
    int TEMPORARY_FAILURE   = 41;
    int SWITCHING_CONGESTION    = 42;
    int ACCESS_INFORMATION_DISCARDED = 43;
    int CHANNEL_NOT_AVAIL   = 44;
    int RESOURCES_UNAVAILABLE_UNSPECIFIED = 47;
    int QOS_NOT_AVAIL       = 49;

    // Service or option unavailable
    /**
     * The user has requested a supplementary service, which is available, but the user is not
     * authorized to use.
     */
    int REQUESTED_FACILITY_NOT_SUBSCRIBED = 50;
    /**
     * Although the called party is a member of the CUG (Closed User Group) for the incoming CUG
     * call, incoming calls are not allowed to this member of the CUG.
     */
    int INCOMING_CALL_BARRED_WITHIN_CUG = 55;
    int BEARER_CAPABILITY_NOT_AUTHORISED = 57;
    int BEARER_NOT_AVAIL    = 58;
    /**
     * This cause is used to report a service or option not available event only when no other cause
     * between 49-62 (where a service or option is unavailable) applies.
     */
    int SERVICE_OR_OPTION_NOT_AVAILABLE = 63;
    int BEARER_SERVICE_NOT_IMPLEMENTED = 65;

    // Service or option not implemented
    int ACM_LIMIT_EXCEEDED = 68;
    int REQUESTED_FACILITY_NOT_IMPLEMENTED = 69;
    /**
     * The calling party has requested an unrestricted bearer service but that the equipment sending
     * this cause only supports the restricted version of the requested bearer capability.
     */
    int ONLY_RESTRICTED_DIGITAL_INFO_BC_AVAILABLE = 70;
    int SERVICE_OR_OPTION_NOT_IMPLEMENTED = 79;
    int INVALID_TRANSACTION_ID_VALUE = 81;

    // Invalid message
    int USER_NOT_MEMBER_OF_CUG = 87;
    int INCOMPATIBLE_DESTINATION = 88;
    int INVALID_TRANSIT_NETWORK_SELECTION = 91;
    int SEMANTICALLY_INCORRECT_MESSAGE = 95;
    int INVALID_MANDATORY_INFORMATION = 96;

    // Protocol error
    int MESSAGE_TYPE_NON_EXISTENT = 97;
    int MESSAGE_TYPE_NOT_COMPATIBLE_WITH_PROT_STATE = 98;
    int IE_NON_EXISTENT_OR_NOT_IMPLEMENTED = 99;
    /**
     * The equipment sending this cause has received an information element which it has
     * implemented; however, one or more fields in the information element are coded in such a way
     * which has not been implemented by the equipment sending this cause.
     */
    int CONDITIONAL_IE_ERROR = 100;
    int MESSAGE_NOT_COMPATIBLE_WITH_PROTOCOL_STATE = 101;
    int RECOVERY_ON_TIMER_EXPIRY = 102;
    int PROTOCOL_ERROR_UNSPECIFIED = 111;
    int INTERWORKING_UNSPECIFIED = 127;

    // Others
    int CALL_BARRED        = 240;
    int FDN_BLOCKED        = 241;
    int IMEI_NOT_ACCEPTED  = 243;

    // Stk Call Control
    int DIAL_MODIFIED_TO_USSD = 244;
    int DIAL_MODIFIED_TO_SS   = 245;
    int DIAL_MODIFIED_TO_DIAL = 246;

    // The call cannot be established because RADIO is OFF
    int RADIO_OFF = 247;

    // The call cannot be established because of no valid SIM
    int NO_VALID_SIM = 249;

    // The call is dropped or failed internally by modem
    int RADIO_INTERNAL_ERROR = 250;

    // Call failed because of UE timer expired while waiting for a response from network
    int NETWORK_RESP_TIMEOUT = 251;

    // Call failed because of a network reject
    int NETWORK_REJECT                                   = 252;
    // Call failed because of radio access failure. ex. RACH failure
    int RADIO_ACCESS_FAILURE                             = 253;
    // Call failed/dropped because of a Radio Link Failure (RLF).
    int RADIO_LINK_FAILURE                               = 254;
    // Call failed/dropped because of radio link lost
    int RADIO_LINK_LOST                                  = 255;
    // Call failed because of a radio uplink issue
    int RADIO_UPLINK_FAILURE                             = 256;
    // Call failed because of a RRC (Radio Resource Control) connection setup failure
    int RADIO_SETUP_FAILURE                              = 257;
    // Call failed/dropped because of RRC (Radio Resource Control) connection release from NW
    int RADIO_RELEASE_NORMAL                             = 258;
    /**
     * Call failed/dropped because of RRC (Radio Resource Control) abnormally released by
     * modem/network.
     */
    int RADIO_RELEASE_ABNORMAL                           = 259;
    //Access class blocked - TS 31.121 5.2.1
    int ACCESS_CLASS_BLOCKED = 260;

    /** Call failed/dropped because of a network detach. */
    int NETWORK_DETACH                                   = 261;

    //Emergency Redial
    int EMERGENCY_TEMP_FAILURE = 325;
    int EMERGENCY_PERM_FAILURE = 326;

    int CDMA_LOCKED_UNTIL_POWER_CYCLE  = 1000;
    int CDMA_DROP                      = 1001;
    int CDMA_INTERCEPT                 = 1002;
    int CDMA_REORDER                   = 1003;
    int CDMA_SO_REJECT                 = 1004;
    int CDMA_RETRY_ORDER               = 1005;
    int CDMA_ACCESS_FAILURE            = 1006;
    int CDMA_PREEMPTED                 = 1007;

    // For non-emergency number dialed while in emergency callback mode.
    int CDMA_NOT_EMERGENCY             = 1008;

    // Access Blocked by CDMA Network.
    int CDMA_ACCESS_BLOCKED            = 1009;

    /** Mapped from ImsReasonInfo */
    // The passed argument is an invalid
    int LOCAL_ILLEGAL_ARGUMENT                           = 1200;
    // The operation is invoked in invalid call state
    int LOCAL_ILLEGAL_STATE                              = 1201;
    // IMS service internal error
    int LOCAL_INTERNAL_ERROR                             = 1202;
    // IMS service goes down (service connection is lost)
    int LOCAL_IMS_SERVICE_DOWN                           = 1203;
    // No pending incoming call exists
    int LOCAL_NO_PENDING_CALL                            = 1204;
    // Service unavailable; by power off
    int LOCAL_POWER_OFF                                  = 1205;
    // Service unavailable; by low battery
    int LOCAL_LOW_BATTERY                                = 1206;
    // Service unavailable; by out of service (data service state)
    int LOCAL_NETWORK_NO_SERVICE                         = 1207;

    /* Service unavailable; by no LTE coverage
     * (VoLTE is not supported even though IMS is registered)
     */
    int LOCAL_NETWORK_NO_LTE_COVERAGE                    = 1208;
    // Service unavailable; by located in roaming area
    int LOCAL_NETWORK_ROAMING                            = 1209;
    // Service unavailable; by IP changed
    int LOCAL_NETWORK_IP_CHANGED                         = 1210;
    // Service unavailable; other
    int LOCAL_SERVICE_UNAVAILABLE                        = 1211;
    // Service unavailable; IMS connection is lost (IMS is not registered)
    int LOCAL_NOT_REGISTERED                             = 1212;
    // Max call exceeded
    int LOCAL_MAX_CALL_EXCEEDED                          = 1213;
    // Call decline
    int LOCAL_CALL_DECLINE                               = 1214;
    // SRVCC is in progress
    int LOCAL_CALL_VCC_ON_PROGRESSING                    = 1215;
    // Resource reservation is failed (QoS precondition)
    int LOCAL_CALL_RESOURCE_RESERVATION_FAILED           = 1216;
    /** Retry CS call; VoLTE service can't be provided by the network or remote end
     *  Resolve the extra code(EXTRA_CODE_CALL_RETRY_*) if the below code is set
     */
    int LOCAL_CALL_CS_RETRY_REQUIRED                     = 1217;
    // Retry VoLTE call; VoLTE service can't be provided by the network temporarily
    int LOCAL_CALL_VOLTE_RETRY_REQUIRED                  = 1218;
    // IMS call is already terminated (in TERMINATED state)
    int LOCAL_CALL_TERMINATED                            = 1219;
    // Handover not feasible
    int LOCAL_HO_NOT_FEASIBLE                            = 1220;

    // 1xx waiting timer is expired after sending INVITE request (MO only)
    int TIMEOUT_1XX_WAITING                              = 1221;
    /** User no answer during call setup operation (MO/MT)
     *  MO : 200 OK to INVITE request is not received,
     *  MT : No action from user after alerting the call
     */
    int TIMEOUT_NO_ANSWER                                = 1222;
    /** User no answer during call update operation (MO/MT)
     *  MO : 200 OK to re-INVITE request is not received,
     *  MT : No action from user after alerting the call
     */
    int TIMEOUT_NO_ANSWER_CALL_UPDATE                    = 1223;

    /**
     * STATUSCODE (SIP response code) (IMS -> Telephony)
     */
    // SIP request is redirected
    int SIP_REDIRECTED                                   = 1300;
    /** 4xx responses */
    // 400 : Bad Request
    int SIP_BAD_REQUEST                                  = 1310;
    // 403 : Forbidden
    int SIP_FORBIDDEN                                    = 1311;
    // 404 : Not Found
    int SIP_NOT_FOUND                                    = 1312;
    /** 415 : Unsupported Media Type
     *  416 : Unsupported URI Scheme
     *  420 : Bad Extension
     */
    int SIP_NOT_SUPPORTED                                = 1313;
    // 408 : Request Timeout
    int SIP_REQUEST_TIMEOUT                              = 1314;
    // 480 : Temporarily Unavailable
    int SIP_TEMPRARILY_UNAVAILABLE                       = 1315;
    // 484 : Address Incomplete
    int SIP_BAD_ADDRESS                                  = 1316;
    /** 486 : Busy Here
     *  600 : Busy Everywhere
     */
    int SIP_BUSY                                         = 1317;
    // 487 : Request Terminated
    int SIP_REQUEST_CANCELLED                            = 1318;
    /** 406 : Not Acceptable
     *  488 : Not Acceptable Here
     *  606 : Not Acceptable
     */
    int SIP_NOT_ACCEPTABLE                               = 1319;
    /** 410 : Gone
     *  604 : Does Not Exist Anywhere
     */
    int SIP_NOT_REACHABLE                                = 1320;
    // Others
    int SIP_CLIENT_ERROR                                 = 1321;
    // 481 : Transaction Does Not Exist
    int SIP_TRANSACTION_DOES_NOT_EXIST                   = 1322;
    /** 5xx responses
     *  501 : Server Internal Error
     */
    int SIP_SERVER_INTERNAL_ERROR                        = 1330;
    // 503 : Service Unavailable
    int SIP_SERVICE_UNAVAILABLE                          = 1331;
    // 504 : Server Time-out
    int SIP_SERVER_TIMEOUT                               = 1332;
    // Other
    int SIP_SERVER_ERROR                                 = 1333;
    /** 6xx responses
     *  603 : Decline
     */
    int SIP_USER_REJECTED                                = 1340;
    // Others
    int SIP_GLOBAL_ERROR                                 = 1341;
    // Emergency failure
    int IMS_EMERGENCY_TEMP_FAILURE                       = 1342;
    int IMS_EMERGENCY_PERM_FAILURE                       = 1343;
    // Media resource initialization failed
    int MEDIA_INIT_FAILED                                = 1400;
    // RTP timeout (no audio / video traffic in the session)
    int MEDIA_NO_DATA                                    = 1401;
    // Media is not supported; so dropped the call
    int MEDIA_NOT_ACCEPTABLE                             = 1402;
    // Unknown media related errors
    int MEDIA_UNSPECIFIED                                = 1403;
    // User triggers the call end
    int USER_TERMINATED                                  = 1500;
    // No action while an incoming call is ringing
    int USER_NOANSWER                                    = 1501;
    // User ignores an incoming call
    int USER_IGNORE                                      = 1502;
    // User declines an incoming call
    int USER_DECLINE                                     = 1503;
    // Device declines/ends a call due to low battery
    int LOW_BATTERY                                      = 1504;
    // Device declines call due to blacklisted call ID
    int BLACKLISTED_CALL_ID                              = 1505;
    // The call is terminated by the network or remote user
    int USER_TERMINATED_BY_REMOTE                        = 1510;

    /**
     * UT
     */
    int UT_NOT_SUPPORTED                                 = 1800;
    int UT_SERVICE_UNAVAILABLE                           = 1801;
    int UT_OPERATION_NOT_ALLOWED                         = 1802;
    int UT_NETWORK_ERROR                                 = 1803;
    int UT_CB_PASSWORD_MISMATCH                          = 1804;

    /**
     * ECBM
     */
    int ECBM_NOT_SUPPORTED                               = 1900;

    /**
     * Fail code used to indicate that Multi-endpoint is not supported by the Ims framework.
     */
    int MULTIENDPOINT_NOT_SUPPORTED                      = 1901;

    /**
     * CALL DROP error codes (Call could drop because of many reasons like Network not available,
     *  handover, failed, etc)
     */

    /**
     * CALL DROP error code for the case when a device is ePDG capable and when the user is on an
     * active wifi call and at the edge of coverage and there is no qualified LTE network available
     * to handover the call to. We get a handover NOT_TRIGERRED message from the modem. This error
     * code is received as part of the handover message.
     */
    int CALL_DROP_IWLAN_TO_LTE_UNAVAILABLE               = 2000;

    // MT call has ended due to a release from the network because the call was answered elsewhere
    int ANSWERED_ELSEWHERE                               = 2100;

    // For MultiEndpoint - Call Pull request has failed
    int CALL_PULL_OUT_OF_SYNC                            = 2101;

    // For MultiEndpoint - Call has been pulled from primary to secondary
    int CALL_PULLED                                      = 2102;

    /**
     * Supplementary services (HOLD/RESUME) failure error codes.
     * Values for Supplemetary services failure - Failed, Cancelled and Re-Invite collision.
     */
    int SUPP_SVC_FAILED                                  = 2300;
    int SUPP_SVC_CANCELLED                               = 2301;
    int SUPP_SVC_REINVITE_COLLISION                      = 2302;

    //DPD Procedure received no response or send failed
    int IWLAN_DPD_FAILURE                                = 2400;

    // Establishment of the ePDG Tunnel Failed
    int EPDG_TUNNEL_ESTABLISH_FAILURE                    = 2500;

    // Re-keying of the ePDG Tunnel Failed; may not always result in teardown
    int EPDG_TUNNEL_REKEY_FAILURE                        = 2501;

    // Connection to the packet gateway is lost
    int EPDG_TUNNEL_LOST_CONNECTION                      = 2502;

    /**
     * The maximum number of calls allowed has been reached.  Used in a multi-endpoint scenario
     * where the number of calls across all connected devices has reached the maximum.
     */
    int MAXIMUM_NUMBER_OF_CALLS_REACHED                  = 2503;

    /**
     * Similar to {@link #CODE_LOCAL_CALL_DECLINE}, except indicates that a remote device has
     * declined the call.  Used in a multi-endpoint scenario where a remote device declined an
     * incoming call.
     */
    int REMOTE_CALL_DECLINE                              = 2504;

    /**
     * Indicates the call was disconnected due to the user reaching their data limit.
     */
    int DATA_LIMIT_REACHED                               = 2505;

    /**
     * Indicates the call was disconnected due to the user disabling cellular data.
     */
    int DATA_DISABLED                                    = 2506;

    /**
     * Indicates a call was disconnected due to loss of wifi signal.
     */
    int WIFI_LOST                                        = 2507;


    /* OEM specific error codes. To be used by OEMs when they don't want to
       reveal error code which would be replaced by ERROR_UNSPECIFIED */
    int OEM_CAUSE_1                                      = 0xf001;
    int OEM_CAUSE_2                                      = 0xf002;
    int OEM_CAUSE_3                                      = 0xf003;
    int OEM_CAUSE_4                                      = 0xf004;
    int OEM_CAUSE_5                                      = 0xf005;
    int OEM_CAUSE_6                                      = 0xf006;
    int OEM_CAUSE_7                                      = 0xf007;
    int OEM_CAUSE_8                                      = 0xf008;
    int OEM_CAUSE_9                                      = 0xf009;
    int OEM_CAUSE_10                                     = 0xf00a;
    int OEM_CAUSE_11                                     = 0xf00b;
    int OEM_CAUSE_12                                     = 0xf00c;
    int OEM_CAUSE_13                                     = 0xf00d;
    int OEM_CAUSE_14                                     = 0xf00e;
    int OEM_CAUSE_15                                     = 0xf00f;

    int ERROR_UNSPECIFIED = 0xffff;

}

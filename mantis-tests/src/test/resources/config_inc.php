<?php
/**
* @package MantisBT
* @copyright Copyright (C) 2000 - 2002  Kenzaburo Ito - kenito@300baud.org
* @copyright Copyright (C) 2002 - 2011  MantisBT Team - mantisbt-dev@lists.sourceforge.net
* @link http://www.mantisbt.org
*/

# This sample file contains the essential files that you MUST
# configure to your specific settings.  You may override settings
# from config_defaults_inc.php by assigning new values in this file

# Rename this file to config_inc.php after configuration.

# In general the value OFF means the feature is disabled and ON means the
# feature is enabled.  Any other cases will have an explanation.

# Look in http://www.mantisbt.org/docs/ or config_defaults_inc.php for more
# detailed comments.

# --- Database Configuration ---
$g_hostname = 'localhost';
$g_db_type = 'mysqli';
$g_database_name = 'bugtracker';
$g_db_username = 'root';
$g_db_password = '';

# --- Anonymous Access / Signup ---
$g_allow_signup				= ON;
$g_allow_anonymous_login	= OFF;
$g_anonymous_account		= '';
$g_signup_use_captcha       = OFF;

# --- Email Configuration ---
$g_phpMailer_method		= PHPMAILER_METHOD_SMTP; #PHPMAILER_METHOD_MAIL or PHPMAILER_METHOD_SMTP, PHPMAILER_METHOD_SENDMAIL
$g_smtp_host			= 'localhost';			# used with PHPMAILER_METHOD_SMTP
$g_smtp_username		= '';					# used with PHPMAILER_METHOD_SMTP
$g_smtp_password		= '';					# used with PHPMAILER_METHOD_SMTP
$g_administrator_email  = 'administrator@example.com';
$g_webmaster_email      = 'webmaster@example.com';
$g_from_name			= 'Mantis Bug Tracker';
$g_from_email           = 'noreply@example.com';	# the "From: " field in emails
$g_return_path_email    = 'admin@example.com';	# the return address for bounced mail
$g_email_receive_own	= OFF;
$g_email_send_using_cronjob = OFF;

# --- Attachments / File Uploads ---
$g_allow_file_upload	= ON;
$g_file_upload_method	= DATABASE; # or DISK
$g_absolute_path_default_upload_folder = ''; # used with DISK, must contain trailing \ or /.
$g_max_file_size		= 5000000;	# in bytes
$g_preview_attachments_inline_max_size = 256 * 1024;
$g_allowed_files		= '';		# extensions comma separated, e.g. 'php,html,java,exe,pl'
$g_disallowed_files		= '';		# extensions comma separated

# --- Branding ---
$g_window_title			= 'MantisBT';
$g_logo_image			= 'images/mantis_logo.gif';
$g_favicon_image		= 'images/favicon.ico';

# --- Real names ---
$g_show_realname = OFF;
$g_show_user_realname_threshold = NOBODY;	# Set to access level (e.g. VIEWER, REPORTER, DEVELOPER, MANAGER, etc)

# --- Others ---
$g_default_home_page = 'my_view_page.php';	# Set to name of page to go to after login
$g_crypto_master_salt = 'k4NfK/cGT10WahJkuXKNTb0gRIAbBDGXnTS/7oKJ5z0=';
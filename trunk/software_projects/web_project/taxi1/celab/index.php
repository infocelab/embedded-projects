<?php 

include "app/config.php";
include "app/detect.php";

if ($page_name=='') {
	include $browser_t.'/index.html';
	}
if ($page_name=='') {
	include $browser_t.'/about.html';
	}

if ($page_name=='') {
	include $browser_t.'/services.html';
	}
if ($page_name=='') {
	include $browser_t.'/contact.html';
	}
else
	{
		include $browser_t.'/404.html';
	}

?>

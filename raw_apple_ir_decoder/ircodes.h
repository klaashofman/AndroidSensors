/******************* our codes ************/

const int ApplePlaySignal[] = {
// ON, OFF (in 10's of microseconds)
	912, 432,
	68, 46,
	66, 160,
	66, 158,
	66, 160,
	62, 54,
	60, 166,
	58, 166,
	58, 168,
	56, 168,
	56, 170,
	56, 168,
	56, 60,
	56, 58,
	56, 58,
	56, 58,
	56, 170,
	56, 170,
	56, 58,
	56, 170,
	54, 60,
	56, 58,
	56, 58,
	56, 58,
	56, 58,
	56, 60,
	54, 60,
	56, 168,
	56, 60,
	56, 58,
	56, 168,
	56, 60,
	54, 170,
	56, 3926,
	892, 224,
	56, 0};

const int AppleForwardSignal[] = {
// ON, OFF (in 10's of microseconds)
	904, 438,
	66, 48,
	64, 162,
	62, 162,
	62, 164,
	60, 54,
	58, 168,
	56, 168,
	56, 170,
	56, 168,
	56, 170,
	54, 170,
	56, 60,
	54, 60,
	54, 60,
	54, 60,
	54, 172,
	54, 60,
	54, 172,
	54, 170,
	54, 60,
	54, 62,
	52, 62,
	52, 62,
	52, 62,
	52, 62,
	54, 62,
	52, 172,
	52, 62,
	54, 62,
	52, 172,
	52, 62,
	54, 172,
	52, 3930,
	896, 220,
	60, 0};

const int AppleRewindSignal[] = {
// ON, OFF (in 10's of microseconds)
	908, 434,
	68, 46,
	68, 158,
	66, 160,
	62, 162,
	62, 52,
	62, 164,
	58, 168,
	56, 170,
	54, 170,
	56, 170,
	54, 170,
	56, 60,
	54, 60,
	54, 60,
	54, 60,
	56, 170,
	54, 170,
	56, 60,
	54, 60,
	54, 170,
	56, 58,
	56, 60,
	54, 60,
	54, 60,
	54, 60,
	54, 60,
	56, 168,
	56, 60,
	54, 60,
	56, 170,
	54, 60,
	54, 170,
	56, 3926,
	894, 220,
	58, 0};

const int AppleUpSignal[] = {
// ON, OFF (in 10's of microseconds)
	910, 434,
	68, 46,
	68, 158,
	66, 160,
	64, 160,
	64, 52,
	60, 166,
	58, 168,
	54, 170,
	56, 170,
	56, 168,
	56, 170,
	54, 60,
	56, 58,
	56, 60,
	54, 60,
	56, 170,
	56, 58,
	56, 170,
	54, 60,
	54, 170,
	56, 58,
	56, 60,
	56, 58,
	56, 58,
	56, 58,
	56, 60,
	54, 170,
	56, 58,
	56, 60,
	54, 170,
	56, 58,
	56, 170,
	56, 3926,
	894, 222,
	58, 0};

const int AppleDownSignal[] = {
// ON, OFF (in 10's of microseconds)
	910, 432,
	68, 48,
	66, 158,
	66, 160,
	64, 162,
	62, 52,
	60, 166,
	58, 168,
	56, 168,
	56, 170,
	56, 168,
	56, 170,
	56, 58,
	56, 58,
	58, 56,
	56, 60,
	54, 170,
	58, 58,
	56, 58,
	56, 168,
	58, 168,
	56, 58,
	58, 56,
	56, 60,
	56, 58,
	56, 58,
	56, 58,
	58, 168,
	56, 58,
	56, 58,
	58, 168,
	56, 58,
	56, 170,
	56, 3924,
	892, 224,
	56, 0};

const int AppleMenuSignal[] = {
// ON, OFF (in 10's of microseconds)
        910, 432,
	70, 46,
	66, 158,
	66, 160,
	64, 162,
	62, 54,
	60, 164,
	60, 166,
	56, 170,
	54, 170,
	56, 170,
	56, 168,
	56, 60,
	56, 58,
	56, 58,
	56, 58,
	58, 168,
	56, 170,
	56, 168,
	58, 58,
	56, 58,
	56, 58,
	56, 58,
	58, 58,
	56, 58,
	56, 58,
        56, 58,
	56, 168,
	58, 58,
	56, 58,
	56, 170,
	56, 58,
	56, 168,
	58, 3924,
	894, 224,
	56, 0};


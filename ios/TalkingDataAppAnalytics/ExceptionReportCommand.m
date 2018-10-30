//
//  ExceptionReportCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/14.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "ExceptionReportCommand.h"

@implementation ExceptionReportCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *exception_report_str = @"\t[TalkingData setExceptionReportEnabled:<#是否开启自动异常捕获#>];";
    
    [self insertEditableWithInvocation:invocation contents:exception_report_str editPosition:exception_report_str.length + 1];
    
    completionHandler(nil);
}

@end

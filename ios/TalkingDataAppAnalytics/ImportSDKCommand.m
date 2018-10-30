//
//  ImportSDKCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/14.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "ImportSDKCommand.h"


@implementation ImportSDKCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *sdk_import_str = @"#import \"TalkingData.h\"";
    
    [self insertEditableWithInvocation:invocation contents:sdk_import_str editPosition:sdk_import_str.length+1];
    
    completionHandler(nil);
}

@end

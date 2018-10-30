//
//  TrackPageEndCommand.m
//  SDKAutoInsertPlugin
//
//  Created by Robin on 2018/10/14.
//  Copyright © 2018 TendCloud. All rights reserved.
//

#import "TrackPageEndCommand.h"

@implementation TrackPageEndCommand

- (void)performCommandWithInvocation:(XCSourceEditorCommandInvocation *)invocation completionHandler:(void (^)(NSError * _Nullable nilOrError))completionHandler
{
    // Implement your command here, invoking the completion handler when done. Pass it nil on success, and an NSError on failure.
    
    NSString *track_page_end_str = @"\t[TalkingData trackPageEnd:<# 应用页面名称。最多包含64个字符。#>];";
    
    [self insertEditableWithInvocation:invocation contents:track_page_end_str editPosition:track_page_end_str.length + 1];
    
    completionHandler(nil);
}

@end
